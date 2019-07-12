package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.CustomerDAO;
import com.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject my DAO in this Controller
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		System.out.println(theCustomers);
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
}
