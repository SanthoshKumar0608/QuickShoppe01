package com.niit.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.QuickShopBackEnd.dao.CartDao;
import com.niit.QuickShopBackEnd.dao.CartItemsDao;
import com.niit.QuickShopBackEnd.dao.CategoryDao;
import com.niit.QuickShopBackEnd.dao.ProductDao;
import com.niit.QuickShopBackEnd.dao.UserDao;
import com.niit.QuickShopBackEnd.model.Cart;
import com.niit.QuickShopBackEnd.model.CartItems;
import com.niit.QuickShopBackEnd.model.Category;
import com.niit.QuickShopBackEnd.model.Product;
import com.niit.QuickShopBackEnd.model.User;



@Controller
public class CartController
{
@Autowired
Product product;
@Autowired
ProductDao productDao;
@Autowired
User user;
@Autowired
UserDao userDao;
@Autowired
Cart cart;
@Autowired
CartDao cartDao;
@Autowired
CartItemsDao cartItemsDao;
@Autowired
CartItems cartItem;
@Autowired
HttpSession session;
@Autowired
Category category;
@Autowired
CategoryDao categoryDao;

@RequestMapping("/addtocart/{pid}")
public ModelAndView cart(@PathVariable("pid") String id)
{
	Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken))
	{
		
		String currusername= authentication.getName();
		User u =userDao.getUseremail(currusername);
	
		if(user==null)
		{
			return new ModelAndView("redirect:/");
		
		}
		else
		{
		
			cart=u.getCart();
				
		Product product1= productDao.getPid(id);
		CartItems cartItem =new CartItems();
		cartItem.setCart(cart);
		cartItem.setProduct(product1);
		cartItem.setPrice(product1.getPrice());
		cartItemsDao.saveorupdate(cartItem);
		cart.setGrand_Total(cart.getGrand_Total()+ product1.getPrice());
		cart.setTotal_Item(cart.getTotal_Item()+1);
		
		cartDao.saveorupdate(cart);
		session.setAttribute("items", cart.getCartitems());
		session.setAttribute("gd", cart.getGrand_Total());
		return new ModelAndView("redirect:/");
		
		}
}
	
	else
	{
		return new ModelAndView("redirect:/");
	}
}
@RequestMapping(value="/viewcart")
public String viewcart(Model model,HttpSession session)
{
	
	Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken))
	{
		String currusername= authentication.getName();
		User u =userDao.getUseremail(currusername);
		Cart c= u.getCart();
		List<CartItems> cartItems=cartItemsDao.list(u.getCart().getCart_Id());
		if(cartItems ==null)
		{
			session.setAttribute("items", 0);
			model.addAttribute("gtotal", 0.0);
			model.addAttribute("msg","no Items is added to cart");
			return "Home";
			
		}
		model.addAttribute("cartItem",cartItems);
		model.addAttribute("gtotal",c.getGrand_Total());
		session.setAttribute("items",c.getTotal_Item());
		
		session.setAttribute("cartId",c.getCart_Id());
		List<Category> categories= categoryDao.list();
		model.addAttribute("lcat", categories);
		return "Viewcart";
}
//	else
//	{
		return "redirect:/viewcart";
//	}
}
@RequestMapping(value="/Remove/{Cartitem_Id}")
public ModelAndView RemoveFromCart(@PathVariable("Cartitem_Id") String id)
{
	ModelAndView obj =new ModelAndView("redirect:/viewcart");
	cartItems =cartItemsDao.get(id);
	Cart c=cartItems.getCart();
	
	c.setGrand_Total(c.getGrand_Total()-cartItem.getPrice());
	
	c.setTotal_Item(c.getTotal_Item()-1);
	cartDao.saveorupdate(c);
	
	
	cartItemsDao.delete(cartItem);
	return obj;
}
@RequestMapping(value="/Removeall")
public String RemoveallFromCart(Model model,HttpSession session)
{
	Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken))
	{
		String currusername= authentication.getName();
		User u =userDao.getUseremail(currusername);
		Cart c= cartDao.get(u.getCart().getCart_Id());
		List<CartItems> cartItem=cartItemDao.getlist(u.getCart().getCart_Id());
		for(CartItems g:cartItem)
		{
			cartItemsDao.delete(g);
		}
		c.setGrand_Total(0.0);
		c.setTotal_Item(0);
		cartDao.saveorupdate(c);
		session.setAttribute("items", c.getTotal_Item());
		return "redirect:/viewcart";
}
	else
	{
		return "redirect:/";
	}
}}
