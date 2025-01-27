package com.example.customerCRUD.controller;

import com.example.customerCRUD.model.Customer;
import com.example.customerCRUD.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all/in")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer_list";
    }

    @GetMapping("/add")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer_form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers/all";
    }

    @GetMapping("/edit/{id}")
    public String showEditCustomerForm(@PathVariable("id") int id, Model model) {
        customerService.getCustomerById(id).ifPresent(customer -> model.addAttribute("customer", customer));
        return "customer_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers/all";
    }

    @GetMapping("/searchByLastName")
    public String searchCustomersByLastName(@RequestParam String lastName, Model model) {
        model.addAttribute("customers", customerService.getCustomersByLastName(lastName));
        return "customer_list";
    }
}
