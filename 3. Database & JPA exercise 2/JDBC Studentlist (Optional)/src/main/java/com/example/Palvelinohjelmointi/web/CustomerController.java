package com.example.Palvelinohjelmointi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Palvelinohjelmointi.domain.Customer;
import com.example.Palvelinohjelmointi.domain.CustomerDAO;

@Controller
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO;
    
    @RequestMapping(value="/customers")
    public String customertList(Model model) {	
        List<Customer> customers = customerDAO.findAll();
        model.addAttribute("customers", customers);
        return "customerlist";
    }	
    
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("customer", new Customer());
        return "addcustomer";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Customer customer){
        customerDAO.save(customer);
        return "redirect:customerlist";
    }    
	
}