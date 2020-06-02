package com.webBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webBackEnd.entity.Products;
import com.webBackEnd.service.ProductsService;

@Controller
//@RestController
@RequestMapping(value = {"/public"})
public class PublicPageController {
	
	@Autowired
	ProductsService productsService;
	
	@GetMapping("/shoppingcenter")
	public ModelAndView index() {
		//Equal to SecurityContextHolder.getContext().getAuthentication()
		ModelAndView modelAndView = new ModelAndView();
		String authen = "anonymous";
		modelAndView.addObject("authen", authen);
		modelAndView.setViewName("shoppingcenter");
		return modelAndView;
	}	
	
	@GetMapping("/racket")
	public ModelAndView racket() {
		//Equal to SecurityContextHolder.getContext().getAuthentication()
		ModelAndView modelAndView = new ModelAndView();
		String authen = "anonymous";
		int category_id = 1000;
		List<Products> products_List = productsService.getProductByCategoryId(category_id);
		modelAndView.addObject("products_List", products_List);
		modelAndView.addObject("authen", authen);
		modelAndView.setViewName("shuttlecock"); // resources/templates/login.html
		return modelAndView;
	}
	
	@GetMapping("/shuttlecock")
	public ModelAndView shuttlecock() {
		//Equal to SecurityContextHolder.getContext().getAuthentication()
		ModelAndView modelAndView = new ModelAndView();
		String authen = "anonymous";
		int category_id = 2000;
		List<Products> products_List = productsService.getProductByCategoryId(category_id);
		modelAndView.addObject("products_List", products_List);
		modelAndView.addObject("authen", authen);
		modelAndView.setViewName("shuttlecock"); // resources/templates/login.html
		return modelAndView;
	}

	@GetMapping("/shoe")
	public ModelAndView shoe() {
		//Equal to SecurityContextHolder.getContext().getAuthentication()
		ModelAndView modelAndView = new ModelAndView();
		String authen = "anonymous";
		int category_id = 3000;
		List<Products> products_List = productsService.getProductByCategoryId(category_id);
		modelAndView.addObject("products_List", products_List);
		modelAndView.addObject("authen", authen);
		modelAndView.setViewName("shuttlecock"); // resources/templates/login.html
		return modelAndView;
	}		
	
	@GetMapping("/sportwear")
	public ModelAndView sportwear() {
		//Equal to SecurityContextHolder.getContext().getAuthentication()
		ModelAndView modelAndView = new ModelAndView();
		String authen = "anonymous";
		int category_id = 4000;
		List<Products> products_List = productsService.getProductByCategoryId(category_id);
		modelAndView.addObject("products_List", products_List);
		modelAndView.addObject("authen", authen);
		modelAndView.setViewName("shuttlecock"); // resources/templates/login.html
		return modelAndView;
	}	
	
	@GetMapping("/bag")
	public ModelAndView bag() {
		//Equal to SecurityContextHolder.getContext().getAuthentication()
		ModelAndView modelAndView = new ModelAndView();
		String authen = "anonymous";
		int category_id = 5000;
		List<Products> products_List = productsService.getProductByCategoryId(category_id);
		modelAndView.addObject("products_List", products_List);
		modelAndView.addObject("authen", authen);
		modelAndView.setViewName("shuttlecock"); // resources/templates/login.html
		return modelAndView;
	}
	
	@GetMapping("/individualproduct")
	public ModelAndView individualproduct(@RequestParam(value = "productid", required = false) int productid) {
		//Equal to SecurityContextHolder.getContext().getAuthentication()
		ModelAndView modelAndView = new ModelAndView();
		String authen = "anonymous";
		Products products = productsService.getProductById(productid);
		modelAndView.addObject("auth_userid", 9999);
		modelAndView.addObject("productid" , productid);
		modelAndView.addObject("productname" , products.getName());
		modelAndView.addObject("productprice" , products.getPrice());
		modelAndView.addObject("productbrand" , products.getBrand());
		modelAndView.addObject("productMadein" , products.getCreated_at());
		modelAndView.addObject("productdescription" , products.getDescription());
		modelAndView.addObject("productquantity" , products.getQuantity());
		modelAndView.addObject("authen", authen);
		System.out.println("ini");
		modelAndView.setViewName("individualproduct");
		return modelAndView;
	}	
	
	@GetMapping("/workingonit")
	public ModelAndView workingonit() {
		//Equal to SecurityContextHolder.getContext().getAuthentication()
		ModelAndView modelAndView = new ModelAndView();
		String authen = "anonymous";
		modelAndView.addObject("authen", authen);
		System.out.println("onit");
		modelAndView.setViewName("workingonit"); // resources/templates/login.html
		return modelAndView;
	}
	
}



