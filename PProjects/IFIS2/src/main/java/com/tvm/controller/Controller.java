package com.tvm.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tvm.model.persistence.Cart;
import com.tvm.model.persistence.Customer;
import com.tvm.model.persistence.Farmer;
import com.tvm.model.persistence.Order;
import com.tvm.model.persistence.Product;
import com.tvm.model.persistence.Transport;
import com.tvm.model.persistence.Vendor;
import com.tvm.model.persistence.VendorProduct;
import com.tvm.model.repository.FarmerRepository;
import com.tvm.model.service.CartService;
import com.tvm.model.service.CustomerService;
import com.tvm.model.service.FarmerService;
import com.tvm.model.service.FarmerServiceImpl;
import com.tvm.model.service.OrderService;
import com.tvm.model.service.ProductService;
import com.tvm.model.service.TransportService;
import com.tvm.model.service.VendorProductService;
import com.tvm.model.service.VendorService;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	FarmerService service;
	
	@Autowired
	VendorService vendorservice;
	
	@Autowired
	ProductService productservice;
	
	@Autowired
	VendorProductService vendorproductservice;
	
	@Autowired
	CustomerService customerservice;
	
	@Autowired
	TransportService transportservice;
	
	@Autowired
	OrderService orderservice;
	
	@Autowired
	CartService cartservice;
	
	@RequestMapping(value= {"/","home"})
	public String index() {
		System.out.println("Home Page");
		return "index";
	}
	@RequestMapping(value= {"/adminpage"})
	public String adminpage() {
		System.out.println("Home Page");
		return "index";
	}
	@RequestMapping("/products")
	public ModelAndView product() {
		System.out.println("product");
		List<VendorProduct> l=vendorproductservice.view();
		return new ModelAndView("products","li",l);
		
	}
	@RequestMapping("/order")
	public ModelAndView order() {
		System.out.println("Order");
		
		List<Product> l=productservice.view();
		return new ModelAndView("order","li",l);
		
	}
	@RequestMapping("/sendfeedback")
	public ModelAndView sendfeedback() {
		System.out.println("Sending Feedback");
		
		return new ModelAndView("redirect:/contact");
		
	}
	@RequestMapping("/sales")
	public ModelAndView next() {
		System.out.println("Sales");
		List<Cart> l=cartservice.view();
		return new ModelAndView("sales","li",l);
		
	}
	
	@RequestMapping("/farmer")
	public String farmer() {
		System.out.println("Farmer Page");
		return "registrationfarmer";
	}
	
	@RequestMapping("/vendor")
	public String vendor() {
		System.out.println("Vendor Page");
		return "vendorpage";
	}
	@RequestMapping("/customer")
	public String customer() {
		System.out.println("Customer Page");
		return "customerpage";
	}
	@RequestMapping("/transport")
	public String transport() {
		System.out.println("Transport Page");
		return "transportpage";
	}
	@RequestMapping("/adminlogin")
	public String adminlogin() {
		System.out.println("Admin login Page");
		return "adminlogin";
	}
	@RequestMapping("/customerlogin")
	public String customerlogin() {
		System.out.println("Customer login Page");
		return "customerlogin";
	}
	@RequestMapping("/vendorlogin")
	public String vendorlogin() {
		System.out.println("Vendor login Page");
		return "vendorlogin";
	}
	
	@RequestMapping("/farmerstock")
	public ModelAndView farmerstock() {
		System.out.println("Farmer Stock");
		List<Product> l=productservice.view();
		return new ModelAndView("farmerstock","li",l);
	}
	@RequestMapping("/vendorstock")
	public ModelAndView vendorstock() {
		System.out.println("Vendor Stock");
		List<VendorProduct> l=vendorproductservice.view();
		return new ModelAndView("vendorstock","li",l);
	}
	@RequestMapping("/contact")
	public String contact() {
		System.out.println("Contact Page");
		return "contact";
	}
	
	@RequestMapping("/registrationfarmer")
	public String registrationfarmer() {
		System.out.println("Registering Farmer Page");
		return "registrationfarmer";
	}
	@RequestMapping(value="/loginfarmer")
	public String loginfarmer() {
		System.out.println("Logging in Farmer Page");
		return "farmerpage";
	}
	@RequestMapping(value="/buynow")
	public String buynow() {
		System.out.println("Buying now Page");
		return "thanksforshopping";
	}
	@RequestMapping(value="/thanks")
	public String thanks() {
		System.out.println("Shopped Page");
		return "thanksforshopping";
	}
	@RequestMapping(value="/assigntransport")
	public ModelAndView assigntransport(@ModelAttribute("j") Cart f) {
		System.out.println("Assigning transport Page");
		List<Transport> l=transportservice.view();
		Object[] objTransport =l.toArray();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("cart", f);
		map.put("transport", objTransport);
		System.out.println(f.getCartid());
		return new ModelAndView("transportassign",map);
	}
	@RequestMapping(value="/assigned")
	public ModelAndView assigned(@RequestParam int id) {
		System.out.println("Assigned transport Page");
		Transport f=transportservice.getById(id);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("li", f);
		System.out.println(f.getId()+" " +f.getDrivername());
		return new ModelAndView("tracktransport",map);
	}
	
	
	@RequestMapping(value="/retrievetransport")
	public ModelAndView retrievetransport(@ModelAttribute ("i") Transport t) {
		System.out.println("Retrieve transport Page");
		List<Transport> l=transportservice.getById(t);
		System.out.println(t.getCity());
		return new ModelAndView("transportassign", "transport", l);
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value="/registersavecart",method=RequestMethod.POST)
	public ModelAndView registersavecart(@ModelAttribute("cart") Cart i) {
		System.out.println("i am in registering customer Cart order action");
		cartservice.add(i);
		List<Cart> l=cartservice.getById(i);
		Object[] objArray = l.toArray();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("cart", objArray);
		cartservice.update(i);
		return new ModelAndView("customercart","cart",l);
	}
	
	

	
	
	
	
	@RequestMapping(value="/registersaveorder",method=RequestMethod.POST)
	public String registersaveorder(@ModelAttribute("z") Order i) {
		System.out.println("i am in registering vender order action");
		orderservice.add(i);
		return "redirect:/order";
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value="/registersavefarmer",method=RequestMethod.POST)
	public ModelAndView registersaveuser(@ModelAttribute("z") Farmer i) {
//		System.out.println("i am in registering farmer action");
		System.out.println("form values"+i.getContactno());
		service.add(i);
		return new ModelAndView("redirect:/home");
	}
	@RequestMapping(value="/registersavevendor",method=RequestMethod.POST)
	public String registersavevendor(@ModelAttribute("z") Vendor i) {
		System.out.println("i am in registering vendor action");
		vendorservice.add(i);
		return "redirect:/home";
	}
	
	@RequestMapping(value="/registersaveproduct",method=RequestMethod.POST)
	public ModelAndView registersaveproduct(@ModelAttribute("z") Farmer f,Product i) {
		System.out.println("i am in registering product action");
		productservice.add(i);
		List<Farmer> l=service.view();
		Object[] objArray = l.toArray();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("farmer", f);
		map.put("product", objArray);
		return new ModelAndView("farmerdashboard",map);
	}
	@RequestMapping(value="/registersavevendorproduct",method=RequestMethod.POST)
	public ModelAndView registersavevendorproduct(@ModelAttribute("z") Vendor v, VendorProduct i) {
		System.out.println("i am in registering vendor product action");
		vendorproductservice.add(i);
		List<Product> l=productservice.view();
		Object[] objArray = l.toArray();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("vendor", v);
		map.put("product", objArray);
		return new ModelAndView("vendordashboard",map);
		
	}
	@RequestMapping(value="/registersavecustomer",method=RequestMethod.POST)
	public ModelAndView registersavecustomer(@ModelAttribute("z") Customer i) {
		System.out.println("i am in registering customer action");
		customerservice.add(i);
		
		return new ModelAndView("redirect:/home");
	}
	
	
	@RequestMapping(value="/registersavetransport",method=RequestMethod.POST)
	public ModelAndView registersavetransport(@ModelAttribute("z") Transport i) {
		System.out.println("i am in registering transport action");
		
		transportservice.add(i);
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/formvalidationadmin", method = RequestMethod.POST)
	public ModelAndView formvalidation(@RequestParam String user , @RequestParam String pass) {
		String username = user;
		String password = pass;
		if (username.equals("admin") && password.equals("123")) {
			return new ModelAndView("admindashboard");
		} else {
			return new ModelAndView("index","wrong","Sorry! Invalid Username or Password...");
		}

	}

	
	@RequestMapping(value = "/formvalidationfarmer", method = RequestMethod.POST)
	public ModelAndView formvalidationuser(@ModelAttribute("userform") Farmer user) {
		System.out.println("I am in validation user page");
		System.out.println(user.getFarmerid() +" " +user.getPassword());
		List<Farmer> f=service.getbyIdAndPassword(user);
		Object[] objArray = f.toArray();
		System.out.println(f.toString());
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("farmer", user);
		map.put("product", objArray);
		System.out.println(user.getFarmerid());
		if(f.size()!=0) {
		return new ModelAndView("farmerdashboard",map);}
		else {
			return new ModelAndView("index","wrong","Sorry! Invalid Username or Password");
		}
		}
	@RequestMapping(value = "/formvalidationvendor", method = RequestMethod.POST)
	public ModelAndView formvalidationvendor(@ModelAttribute("userform") Vendor user) {
		System.out.println("I am in validation user page");
		System.out.println(user.getVendorid()+" " +user.getPassword());
		List<Vendor> f=vendorservice.getbyIdAndPassword(user);
		List<Product> l=productservice.view();
		List<Farmer> fa=service.view();
		Object[] objArray = l.toArray();
		System.out.println(f.toString());
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("vendor", user);
		map.put("product", objArray);
		map.put("farmer", fa);
		if(f.size()!=0) {
		return new ModelAndView("vendordashboard",map);
		}
		else {
			return new ModelAndView("index","wrong","Sorry! Invalid Username or Password");
		}}

	@RequestMapping(value = "/formvalidationcustomer", method = RequestMethod.POST)
	public ModelAndView formvalidationcustomer(@ModelAttribute("userform") Customer user,Product p) {
		System.out.println("I am in validation user page");
		System.out.println(user.getCustomerid() +" " +user.getPassword());
		List<Customer> f=customerservice.getbyIdAndPassword(user);
		List<VendorProduct> l=vendorproductservice.view();
		Object[] objArray = l.toArray();
		System.out.println(l.size());
		/*HashMap<String, ArrayList<? extends Collection>> map = new HashMap<String, ArrayList<? extends Collection>>();
		map.put("customer", (ArrayList<? extends Collection>) f);
		map.put("product", (ArrayList<? extends Collection>) l);*/
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("customer", user);
		map.put("product", objArray);
		System.out.println(l.size());
		if(f.size()!=0) {
		return new ModelAndView("customerdashboard", map);
		}else {
			return new ModelAndView("index","wrong","Sorry! Invalid Username or Password");
		}}
		
		
	
	
	
	
	
	
	
	
}
