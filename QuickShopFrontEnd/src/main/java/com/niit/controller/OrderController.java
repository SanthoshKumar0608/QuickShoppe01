package com.niit.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.QuickShopBackEnd.dao.BillingDao;
import com.niit.QuickShopBackEnd.dao.CartDao;
import com.niit.QuickShopBackEnd.dao.CartItemsDao;
import com.niit.QuickShopBackEnd.dao.CategoryDao;
import com.niit.QuickShopBackEnd.dao.OrderDao;
import com.niit.QuickShopBackEnd.dao.OrderItemsDao;
import com.niit.QuickShopBackEnd.dao.PayDao;
import com.niit.QuickShopBackEnd.dao.ProductDao;
import com.niit.QuickShopBackEnd.dao.ShippingDao;
import com.niit.QuickShopBackEnd.dao.UserDao;
import com.niit.QuickShopBackEnd.model.Billing;
import com.niit.QuickShopBackEnd.model.Cart;
import com.niit.QuickShopBackEnd.model.CartItems;
import com.niit.QuickShopBackEnd.model.Category;
import com.niit.QuickShopBackEnd.model.Order;
import com.niit.QuickShopBackEnd.model.OrderItems;
import com.niit.QuickShopBackEnd.model.Pay;
import com.niit.QuickShopBackEnd.model.Product;
import com.niit.QuickShopBackEnd.model.Shipping;
import com.niit.QuickShopBackEnd.model.User;



@Controller
public class OrderController {
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItems cartItem;
	@Autowired
	CartItemsDao cartItemDao;
	//@Autowired
	//Card card;
	@Autowired
	Billing billing;
	@Autowired
	BillingDao billingDao;
	@Autowired
	Shipping shipping;
	@Autowired
	ShippingDao shippingDao;
	@Autowired
	Pay pay;
	@Autowired
	PayDao payDao;
	@Autowired
	Order order;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItems orderItem;
	@Autowired
	OrderItemsDao orderItemDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	List<CartItems> cartItems;
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	

//	@Autowired
//	private JavaMailSender mailSender;
//		
//	String o;

	@RequestMapping("/Buyall")
	public String orderall(Model model,HttpSession session)
	{
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currusername= authentication.getName();
			user = userDao.getUseremail(currusername);
			cart=user.getCart();
			product=null;
			session.setAttribute("products", product);
//			cartItem=cartItemDao.get(cart.getCart_Id());
			cartItem1=cartItemDao.getlist(cart.getCart_Id());
			
			if(cartItem1==null || cartItem1.isEmpty())
			{
				return "redirect:/viewcart";
			}
			else
			{
			//billing=billingDao.get(user.getUid());
			List<Shipping> shippings=shippingDao.getaddbyUser(user.getUid());
			model.addAttribute("billing",billing);
			model.addAttribute("user",user);
			model.addAttribute("shippings",shippings);
			model.addAttribute("shipping",new Shipping());
			model.addAttribute("p", product);
			session.setAttribute("p",product);
			List<Category> categories= categoryDao.list();
			model.addAttribute("lcat", categories);
		}}
		return "address";
	}

	@RequestMapping("/Buy/{pid}/{Cartitem_Id}")
	public String order(@PathVariable("pid") String id,Model model,HttpSession session)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currusername= authentication.getName();
			user = userDao.getUseremail(currusername);
			cart= user.getCart();
//			cartItem=null;
			product=productDao.get(id);
			billing=billingDao.get(user.getUid());
			cartItem=cartItemDao.get(cart.getCart_Id());
//			System.out.println(billing.getCountry());
//			for(Billing b: billing)
//			{
//				System.out.println(b.getbId());
//				System.out.println(b.getCountry());
//			}
	      List<Shipping> shippings=shippingDao.getaddbyUser(user.getUid());
			user.setBilling(billing);
			model.addAttribute("billing",billing);
			model.addAttribute("user",user);
			model.addAttribute("shippings",shippings);
			model.addAttribute("shipping",new Shipping());
			session.setAttribute("p",product);
			model.addAttribute("citem", cartItem);
			List<Category> categories= categoryDao.list();
			model.addAttribute("lcat", categories);
			return "address";
		}
		else
		{
			return"redirect:/";
		}
	}

	@RequestMapping("/orderConfirm")
	public String payment(@ModelAttribute("shipping")Shipping sh,Model model)
	{
//		if(cartItem==null || cartItem.isEmpty())
//		{
//			System.out.println("sorry");
//		}
		sh.setUser(user);
		shipping=sh;
		model.addAttribute("billing",billing);
		model.addAttribute("shippingAddress",shipping);
		model.addAttribute("prot",product);
		model.addAttribute("cartItem1",cartItem1);
		model.addAttribute("cart",cart);
		List<Category> categories= categoryDao.list();
		model.addAttribute("lcat", categories);
		return "orderconfirm";
	}

	@RequestMapping("/previous")
	public String previous(Model model)
	{
		List<Shipping> shippings=shippingDao.getaddbyUser(user.getUid());
		model.addAttribute("shippingAddresies",shipping);
		model.addAttribute("billing",billing);
		model.addAttribute("shipping", shippings);
		model.addAttribute("product",product);
		return "addressorder";
	}

	@RequestMapping("/pay")
	public String pay(Model model)
	{
//		List<Card> cards=cardDao.getcardbyuser(userInfo.getuId());
//		model.addAttribute("cards",cards);
//		model.addAttribute("card",new Card());
		List<Category> categories= categoryDao.list();
		model.addAttribute("lcat", categories);

		return "Payment";
	}

//	@RequestMapping("/payment")
//	public String payment(@RequestParam("otp") String otp,Model model)
//	{
//		int a;
//		if(otp==null)
//			a=2;
//		else
//			a=1;
//		switch (a)
//		{
//		case 1:
//			if(otp.equals(o))
//			{
//				pay.setPay_Method("COD");
//				pay.setStatus("NO");
//				break;
//			}
//			else
//			{
//				return "redirect:/pay";
//			
//			}
//		case 2:
//			pay.setPay_Method("Card");
//			pay.setStatus("yes");
//			payDao.saveorupdate(pay);
////			cardDao.saveorupdate(car);
			break;
			
		}
		List<Category> categories= categoryDao.list();
		model.addAttribute("lcat", categories);
		return "redirect:/Thankyou";
		
	}
//	@RequestMapping("/payment")
//	public String payment(@RequestParam("payb2") String str,Model model)
//	{
//		System.out.println(1324);
//		int a;
//		System.out.println(str);
//		if(str.equals(o))
//		{
//			return "redirect:/thankyou";
//		}
//		
//		return "redirect:/orderconfirmation";
//		
//		
//	}
	@RequestMapping("/orderconfirmation")
	public String orderconfirmation(HttpSession session)
	{
//		System.out.println(32);
		order.setBilling(billing);
		order.setShipping(shipping);
		order.setPay(pay);
		//order.setUser(user);
//		System.out.println(524);
		if(cartItem == null)
		{
			order.setGrand_Total(product.getPrice());
			orderDao.saveorupdate(order);
			orderItem.setOrder(order);
			//orderItem.setProductid(productInfo.getPrdid());
			orderItemDao.saveorupdate(orderItem);
			cart.setGrand_Total(cart.getGrand_Total() - cartItem.getPrice());
			cart.setTotal_Item(cart.getTotal_Item()-1);
			session.setAttribute("items", cart.getTotal_Item());
			cartDao.saveorupdate(cart);
			//cartItemDao.delete(cartItemDao.getlistall(cart.getCart_id(),productInfo.getPrdid()));
			System.out.println(324);
		}
		else
		{
			System.out.println(656);
			order.setGrand_Total(cart.getGrand_Total());
			orderDao.saveorupdate(order);
			for(CartItems c: cartItems)
			{
				System.out.println(3444);
				orderItem.setOrder(order);
				//orderItem.setProductid(c.getProductInfo().getPrdid());
				System.out.println(3443);
				orderItemDao.saveorupdate(orderItem);
				cartItemDao.delete(c);
			}
			cart.setGrand_Total(0.0);
			cart.setTotal_Item(0);
			System.out.println(346);
			session.setAttribute("items", cart.getTotal_Item());
			cartDao.saveorupdate(cart);
			
		}
		cartItem=null;
		cartItems=null;
		product=null;
		order=new Order();
		orderItem=new OrderItems();
		System.out.println(565);
		
		return "Thankyou";
		
		
	}
//	@RequestMapping(value="/SendMail")
//	public void SendMail() {
////	System.out.println(21312);
//	Authentication authentication =	SecurityContextHolder.getContext().getAuthentication();
//	if (!(authentication instanceof AnonymousAuthenticationToken)) {
//	String currusername = authentication.getName();
//	user = userDao.getUseremail(currusername);
//	Otp_Generator ot=new Otp_Generator();
//	// String o=ot.Otpga();
//	o=ot.Otpga();
//	String recipientAddress = user.getUemail();
//	String subject="OTP";
//	//String subject = request.getParameter("subject");
//	String message = "your one time password is "+o+" ";
//
//	// prints debug info
//	System.out.println("To:" + recipientAddress);
//	System.out.println("Subject: " + subject);
//	System.out.println("Message: " + message);


//	System.out.println("OTP:"+ otp);
//	creates a simple e-mail object
//	SimpleMailMessage email = new SimpleMailMessage();
//	email.setTo(recipientAddress);
//	email.setSubject(subject);
//	email.setText(message);
//	email.setSubject(otp);
//  sends the e-mail
//	mailSender.send(email);
//
//
// forwards to the view named "Result"
//	return "Result";
//	}
	//}
	


