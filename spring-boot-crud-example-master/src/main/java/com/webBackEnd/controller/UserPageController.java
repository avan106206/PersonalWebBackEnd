package com.webBackEnd.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webBackEnd.dao.UserCartProjection;
import com.webBackEnd.entity.Cart;
import com.webBackEnd.entity.Products;
import com.webBackEnd.entity.User;
import com.webBackEnd.service.CartService;
import com.webBackEnd.service.CurrentUserInfoService;
import com.webBackEnd.service.ProductsService;
import com.webBackEnd.service.SecurityContextHandlerInterface;

@Controller
//@RestController
@RequestMapping(value = {"/user"})
public class UserPageController {
	
	
	@Autowired
	private CurrentUserInfoService currentUserInfoService;

	@Autowired
	private ProductsService productsService;
	
	@Autowired
    private SecurityContextHandlerInterface securityContextHandlerInterface;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index() {
		Authentication authentication = securityContextHandlerInterface.getAuthentication();
		//Equal to SecurityContextHolder.getContext().getAuthentication()
		ModelAndView modelAndView = new ModelAndView();
		User user = currentUserInfoService.findByemail(authentication.getName());//authentication.getname is actually the login email
		String name = user.getName();
		modelAndView.addObject("name", name);
		modelAndView.setViewName("user"); // resources/templates/login.html
		return modelAndView;
	}
	
	@GetMapping("/shoppingcenter")
	public ModelAndView product() {
		//Equal to SecurityContextHolder.getContext().getAuthentication()
		ModelAndView modelAndView = new ModelAndView();
		String authen = "user";
		modelAndView.addObject("authen", authen);
		modelAndView.setViewName("shoppingcenter"); // resources/templates/login.html
		return modelAndView;
	}
	
	@GetMapping("/racket")
	public ModelAndView racket() {
		//Equal to SecurityContextHolder.getContext().getAuthentication()
		ModelAndView modelAndView = new ModelAndView();
		String authen = "user";
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
		String authen = "user";
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
		String authen = "user";
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
		String authen = "user";
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
		String authen = "user";
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
		String authen = "user";
		Products products = productsService.getProductById(productid);
		modelAndView.addObject("productid" , productid);
		modelAndView.addObject("productname" , products.getName());
		modelAndView.addObject("productprice" , products.getPrice());
		modelAndView.addObject("productbrand" , products.getBrand());
		modelAndView.addObject("productMadein" , products.getCreated_at());
		modelAndView.addObject("productdescription" , products.getDescription());
		modelAndView.addObject("productquantity" , products.getQuantity());
		modelAndView.addObject("authen", authen);
		modelAndView.setViewName("individualproduct");
		return modelAndView;
	}	
	
	@GetMapping("/workingonit")
	public ModelAndView workingonit() {
		//Equal to SecurityContextHolder.getContext().getAuthentication()
		ModelAndView modelAndView = new ModelAndView();
		String authen = "user";
		modelAndView.addObject("authen", authen);
		modelAndView.setViewName("workingonit"); // resources/templates/login.html
		return modelAndView;
	}
	
	
//	@GetMapping("/addcart")
//	public ModelAndView addcart(@RequestParam(value = "productid", required = false) int productid,
//			@RequestParam(value = "NeedNum", required = false) int neednum) {
//		Cart cart = new Cart();
//		/**Get current user id and set user id to cart entity**/
//		Authentication authentication = securityContextHandlerInterface.getAuthentication();
//		User user = currentUserInfoService.findByemail(authentication.getName());
//		//cart.setAuth_user_id(user.getId());
//		/**Set the product id and need number**/
//		cart.setAuth_user_id(user.getId());
//		cart.setProduct_id(productid);
//		cart.setNeednum(neednum);
//		/**insert the cart entity**/
//		cartService.saveCart(cart);
//		ModelAndView modelAndView = new ModelAndView();
//		String authen = "user";
//		Products products = productsService.getProductById(productid);
//		modelAndView.addObject("productid" , productid);
//		modelAndView.addObject("productname" , products.getName());
//		modelAndView.addObject("productprice" , products.getPrice());
//		modelAndView.addObject("productbrand" , products.getBrand());
//		modelAndView.addObject("productMadein" , products.getCreated_at());
//		modelAndView.addObject("productdescription" , products.getDescription());
//		modelAndView.addObject("productquantity" , products.getQuantity());
//		modelAndView.addObject("authen", authen);
//		modelAndView.setViewName("individualproduct");
//		return modelAndView;
//		//return "redirect:/user/viewcart";
//	}
	
	@GetMapping("/addcart")
	public ModelAndView addcart(@RequestParam(value = "productid", required = false) int productid,
			@RequestParam(value = "NeedNum", required = false) int neednum) {
		Cart cart = new Cart();
		/**Get current user id and set user id to cart entity**/
		Authentication authentication = securityContextHandlerInterface.getAuthentication();
		User user = currentUserInfoService.findByemail(authentication.getName());
		//cart.setAuth_user_id(user.getId());
		/**Set the product id and need number**/
		cart.setAuth_user_id(user.getId());
		cart.setProduct_id(productid);
		cart.setNeednum(neednum);
		/**insert the cart entity**/
		cartService.saveCart(cart);
		int userid = user.getId();
		System.out.println(userid);
		String first_username = user.getName();
		String last_username = user.getLastName();
		String email = user.getEmail();
		List<UserCartProjection> cart_items = currentUserInfoService.getCurrentCart();
		ModelAndView modelAndView = new ModelAndView();
		String authen = "user";
		boolean isempty = (cart_items.size() == 0)?true:false;
		boolean isadded = true;
		modelAndView.addObject("isadded", isadded);
		modelAndView.addObject("isempty", isempty);
		modelAndView.addObject("email", email);
		modelAndView.addObject("user_lastname", last_username);
		modelAndView.addObject("user_firstname", first_username);
		modelAndView.addObject("cart_items", cart_items);
		modelAndView.addObject("authen", authen);
		modelAndView.setViewName("cart"); // resources/templates/login.html
		return modelAndView;
		//return "redirect:/user/viewcart";
	}	
	
	
    @GetMapping("/deleteCartItem/{id}")
    public String deleteStudent(@PathVariable("id") int id, Model model) {
    	System.out.println(id);
    	cartService.deleteCart(id);
    	List<UserCartProjection> cart_items = currentUserInfoService.getCurrentCart();
    	model.addAttribute("cart_items", cart_items);
        return "cart";
    }
    
	@GetMapping("/viewcart")
	public ModelAndView viewcart() {
		Authentication authentication = securityContextHandlerInterface.getAuthentication();
		User user = currentUserInfoService.findByemail(authentication.getName());//authentication.getname is actually the login email
		int userid = user.getId();
		System.out.println(userid);
		String first_username = user.getName();
		String last_username = user.getLastName();
		String email = user.getEmail();
		List<UserCartProjection> cart_items = currentUserInfoService.getCurrentCart();
		ModelAndView modelAndView = new ModelAndView();
		String authen = "user";
		boolean isempty = (cart_items.size() == 0)?true:false;
		boolean isadded = true;
		modelAndView.addObject("isadded", isadded);
		modelAndView.addObject("isempty", isempty);
		modelAndView.addObject("email", email);
		modelAndView.addObject("user_lastname", last_username);
		modelAndView.addObject("user_firstname", first_username);
		modelAndView.addObject("cart_items", cart_items);
		modelAndView.addObject("authen", authen);
		modelAndView.setViewName("cart"); // resources/templates/login.html
		return modelAndView;
	}
}