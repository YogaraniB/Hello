package com.asminds.Mvc.validation.Controller;
	import javax.validation.Valid;

	import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

	@Controller
	public class MvcvalidationController  {    

	        @RequestMapping(value="displayForm", method=RequestMethod.GET)
	        public String helloWorld(UserDetails ud) {
			System.out.println("Hai");
	            return "loginPage";            
	        }

	        @RequestMapping("/login")
	        public String loginCheck(@Valid UserDetails userDetails, BindingResult result, ModelMap model) {
	            if (result.hasErrors()) {
	                return "loginPage";
	            } else {
	                model.addAttribute("lfobj", userDetails);
	                return "success";
	            }
	        }

	}
