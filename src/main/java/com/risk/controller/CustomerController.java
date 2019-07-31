
package com.risk.controller;

import java.util.List;

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
import com.risk.model.FoodMenu;
import com.risk.service.CustomerService;
import com.risk.service.FoodMenuService;

@Controller public class CustomerController {
  
  @Autowired 
  private CustomerService customerService;
  
  @Autowired 
  private FoodMenuService foodMenuService;
  
  // binding customer model
  
  @RequestMapping(value = "/customer", method = RequestMethod.GET) public
  String greet(Model model) {
  
  model.addAttribute("customer", new Customer()); return "customer"; }
  
 /*saving the customer data into database and directing page to registerSuccess*/
  
  @RequestMapping(value = { "/registerSuccess" }, method = RequestMethod.POST)
  public String saveEmployee(@Valid @ModelAttribute("customer") Customer
  customer, BindingResult result) {
  
  if (result.hasErrors()) { return "customer"; }
  customerService.saveCustomer(customer); return "registerSuccess"; }
  
  //FoodMenu code_anshu
  
  @RequestMapping(value = "/", method = RequestMethod.GET) public String
  listOrders(Model model) { List<FoodMenu> foodMenu =
  foodMenuService.getFoodMenuList(); model.addAttribute("foodMenu", foodMenu);
  int limit = 10; model.addAttribute("limit", limit); return "foodMenu"; }
  
  }
