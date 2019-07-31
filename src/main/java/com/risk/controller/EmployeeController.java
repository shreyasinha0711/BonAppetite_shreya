
  package com.risk.controller;
  
  import javax.validation.Valid;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Controller; import
  org.springframework.ui.Model; import org.springframework.ui.ModelMap; import
  org.springframework.validation.BindingResult; import
  org.springframework.web.bind.annotation.ModelAttribute; import
  org.springframework.web.bind.annotation.RequestMapping; import
  org.springframework.web.bind.annotation.RequestMethod;
  
  import com.risk.model.Employee; import com.risk.service.EmployeeService;
  
  @Controller public class EmployeeController {
  
  @Autowired private EmployeeService employeeService;
  
  @RequestMapping(value = "/") public String register(Model model) {
  model.addAttribute("employee", new Employee());
  
  return "register"; }
  
  @RequestMapping(value = "/registerSuccess", method = RequestMethod.POST)
  public String registerSuccess(@Valid @ModelAttribute("employee") Employee
  employee, BindingResult result,ModelMap model) {
  
  if (result.hasErrors()) { return "register"; }
  
  employeeService.saveEmployee(employee);
  
  //model.addAttribute("success", "Employee " + user.getName() +" registered successfully"); 
  return "success";
  
  
  } }
 