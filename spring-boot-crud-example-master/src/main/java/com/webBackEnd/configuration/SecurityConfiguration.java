package com.webBackEnd.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;//Autowire the bean of BCryptPasswordEncoder registered in WebMvcConfiguration.java


	@Autowired
	private DataSource dataSource;

	@Autowired
	private CustomerLoginSuccessHandler sucessHandler;
	
	@Value("${spring.queries.users-query}")//query for authentication
	private String usersQuery;

	@Value("${spring.queries.roles-query}")//query for authorization
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
	}//use the usersQuery and rolesQuery we set in the properties to achieve the authentication and authorization 

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublish() { //listener to monitor if the session is destoried, because the maximum session is limited to 2
		return new HttpSessionEventPublisher();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				// URLs matching for access rights
				.antMatchers("/", "/assets/img/**", "/authentication/login", "/authentication/register","/fragment", "/index", "/public/**").permitAll()
				.antMatchers("/user/**", "/logout", "/user/shoppingcenter/**").hasAnyAuthority("SUPER_USER", "ADMIN_USER", "SITE_USER")
				.antMatchers("/authentication/admin/**").hasAnyAuthority("SUPER_USER","ADMIN_USER")
				.anyRequest().authenticated()
				.and()//end of antMatchers
				.csrf().disable().formLogin() //for login
				.loginPage("/authentication/login")//when the post request coming from /login, trigger this part
				.failureUrl("/authentication/login?error=true")
				.successHandler(sucessHandler)//Autowire to CustomerLoginSucessHandler
				.usernameParameter("email")
				.passwordParameter("password")
				.and()
				.logout() //for logout
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/")
				.and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied")
				.and()
				.sessionManagement()
				.sessionFixation().migrateSession()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
				.invalidSessionUrl("/")
				.maximumSessions(2)
				.expiredUrl("/")//The session timeout is set in application-properties		
				;
	}

	@Override
	public void configure(WebSecurity web) throws Exception { //configure with WebSecurity as a parameter(https)
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}