package com.webBackEnd.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@ConfigurationProperties("spring.datasource")
@PropertySource("classpath:application.properties")
@SuppressWarnings("unused")
public class DBConfiguration {
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Profile("prod")
	@Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(Environment env) {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setEnvironment(env);
        return configurer;
	}
	
	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		System.out.println("DB connection for DEV");
		System.out.println(driverClassName);
		System.out.println(url);
		return("DEV database connected successfully");
	}

}