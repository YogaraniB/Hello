package com.tvm.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tvm.model.repository.Customer;
import com.tvm.model.repository.Farmer;
import com.tvm.model.repository.FarmerRepository;
import com.tvm.model.repository.Order;
import com.tvm.model.repository.Product;
import com.tvm.model.repository.Transport;
import com.tvm.model.repository.Vendor;
import com.tvm.model.service.CustomerService;
import com.tvm.model.service.FarmerService;
import com.tvm.model.service.FarmerServiceImpl;
import com.tvm.model.service.OrderService;
import com.tvm.model.service.ProductService;
import com.tvm.model.service.TransportService;
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
	CustomerService customerservice;
	
	@Autowired
	TransportService transportservice;
	
	@Autowired
	OrderService orderservice;
	
	@RequestMapping(value= {"/","home"})
	public String index() {
		System.out.println("next");
		return "index";
	}
	@RequestMapping("/products")
	public String product() {
		System.out.println("product");
		return "products";
	}
	@RequestMapping("/order")
	public ModelAndView order() {
		System.out.println("Order");
		List<Product> l=productservice.view();
		return new ModelAndView("order","li",l);
		
	}
	@RequestMapping("/sales")
	public String next() {
		System.out.println("next");
		return "sales";
	}
	@RequestMapping("/technology")
	public String technology() {
		System.out.println("next");
		return "technology";
	}
	@RequestMapping("/farmer")
	public String farmer() {
		System.out.println("Farmer Page");
		return "registrationfarmer";
	}
	
	@RequestMapping("/vendor")
	public String vendor() {
		System.out.println("Farmer Page");
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
	@RequestMapping("/customerlogin")
	public String customerlogin() {
		System.out.println("Customer login Page");
		return "customerlogin";
	}
	@RequestMapping("/stock")
	public ModelAndView stock() {
		System.out.println("next");
		List<Product> l=productservice.view();
		return new ModelAndView("stock","li",l);
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
		System.out.println("Registering Farmer Page");
		return "farmerpage";
	}
	@RequestMapping(value="/registersavefarmer",method=RequestMethod.POST)
	public ModelAndView registersaveuser(@ModelAttribute("z") Farmer i) {
//		System.out.println("i am in registering farmer action");
		System.out.println("form values"+i.getContactno());
		service.add(i);
		return new ModelAndView("farmerpage");
	}
	@RequestMapping(value="/registersavevendor",method=RequestMethod.POST)
	public String registersavevendor(@ModelAttribute("z") Vendor i) {
		System.out.println("i am in registering farmer action");
		
		vendorservice.add(i);
		
				
		return "redirect:/home";
	}
	
	@RequestMapping(value="/registersaveproduct",method=RequestMethod.POST)
	public ModelAndView registersaveproduct(@ModelAttribute("z") Product i) {
		System.out.println("i am in registering farmer action");
		
		productservice.add(i);
		return new ModelAndView("farmerdashboard");
	}
	@RequestMapping(value="/registersavecustomer",method=RequestMethod.POST)
	public ModelAndView registersavecustomer(@ModelAttribute("z") Customer i) {
		System.out.println("i am in registering customer action");
		
		customerservice.add(i);
		return new ModelAndView("customerlogin");
	}
	
	@RequestMapping(value="/registersavetransport",method=RequestMethod.POST)
	public ModelAndView registersavetransport(@ModelAttribute("z") Transport i) {
		System.out.println("i am in registering transport action");
		
		transportservice.add(i);
		return new ModelAndView("redirect:/home");
	}
	@RequestMapping(value="/registersaveorder",method=RequestMethod.POST)
	public ModelAndView registersaveorder(@ModelAttribute("z") Order i) {
		System.out.println("i am in registering order action");
		orderservice.add(i);
		return new ModelAndView("redirect:/order");
	}
	
	
	
	@RequestMapping(value = "/formvalidationfarmer", method = RequestMethod.POST)
	public ModelAndView formvalidationuser(@ModelAttribute("userform") Farmer user) {
		System.out.println("I am in validation user page");
		System.out.println(user.getFarmerid() +" " +user.getPassword());
		List<Farmer> f=service.getbyIdAndPassword(user);
		
		return new ModelAndView("farmerdashboard");
		}

	@RequestMapping(value = "/formvalidationcustomer", method = RequestMethod.POST)
	public ModelAndView formvalidationcustomer(@ModelAttribute("userform") Customer user,Product p) {
		System.out.println("I am in validation user page");
		System.out.println(user.getCustomerid() +" " +user.getPassword());
		List<Customer> f=customerservice.getbyIdAndPassword(user);
		List<Product> l=productservice.view();
		return new ModelAndView("customerdashboard","li",l);
		}
		
		
	
	
	
	
	
	
	
	
}
