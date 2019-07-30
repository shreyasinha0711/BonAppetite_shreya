package com.risk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.risk.model.Customer;
import com.risk.service.CustomerService;
@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

		@RequestMapping(value="/", method=RequestMethod.GET)
		public String greet(Model model){
			
			model.addAttribute("customer", new Customer());
			return "customer";
		}
		
	/*
	 * @RequestMapping(value="/registerSuccess", method=RequestMethod.POST) public
	 * ModelAndView display(
	 * 
	 * @RequestParam("fname")String strFName,
	 * 
	 * @RequestParam("lname")String strLName,
	 * 
	 * @RequestParam("email")String strEmail,
	 * 
	 * @RequestParam("phone")String strPhone,
	 * 
	 * @RequestParam("address")String strAddress,
	 * 
	 * @RequestParam("payment")String strPayment) {
	 * 
	 * Customer customer = new Customer(strFName, strLName, strEmail, strPhone,
	 * strAddress, strPayment); ModelAndView mav = new
	 * ModelAndView("registerSuccess"); mav.addObject("customer", customer); return
	 * mav; }
	 */
		
		   @RequestMapping(value = { "/registerSuccess" }, method = RequestMethod.POST)
		    public String saveEmployee(@Valid  @ModelAttribute("customer") Customer customer, BindingResult result) {
		 
		        if (result.hasErrors()) {
		            return "customer";
		        }
		 
		        customerService.saveCustomer(customer);
		 
		       // model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
		        return "registerSuccess";
		    }
}
