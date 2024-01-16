package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.entity.Customer;
import com.marketing.services.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	

	@PostMapping("/saveCustomer")
	public String saveCustomers(@ModelAttribute Customer customer) 
	{
		try {
		boolean userStatus = customerService.emailExist(customer.getEmail());
		if(userStatus ==false) {
			customerService.saveCustomer(customer);
			return "index";
		}
		return "emailcheck";
		}
		catch(Exception e)
		{
			return "validation";
		}

	}
	@PostMapping("/view_customer")
	public String fetchCustomer(@RequestParam String email, Model model) {
		try {
			Customer customers = this.customerService.findCustomer(email);
			model.addAttribute("customers", customers);
			return "viewcustomer";
			}
			catch(Exception e)
			{
				return "validation";
			}
	}
	
	@GetMapping("/view")
	public String fetchAllCustomer(Model model)
	{
		try {
		List<Customer> customers = this.customerService.getAllCustomer();
		model.addAttribute("customers", customers);
		return "viewcustomer";
		}
		catch(Exception e)
		{
			return "validation";
		}
	}

	@PostMapping("/delete")
	public String deleteCustomer(@RequestParam String email) {
		try {
		this.customerService.deleteCustomer(email);
		return "index";
		}
		catch(Exception e)
		{
			return "validation";
		}
	}
	
	@PostMapping("/update")
	public String updateDelete(@RequestParam String email) {
		try {
		customerService.deleteCustomer(email);
		return "updatecustomer";
		}
		catch(Exception e)
		{
			return "validation";
		}
		
		
	}
	@PostMapping("/update_customer")
	public String updateCustomer(@ModelAttribute Customer customer) {
		try {
		customerService.updateCustomer(customer);
		return "index";
		}
		catch(Exception e)
		{
			return "validation";
		}
	}

}
