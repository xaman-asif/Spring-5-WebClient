package com.webclient.provider.controller;

import com.webclient.provider.model.Customer;
import com.webclient.provider.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provider")
public class CustomerRestController {

    CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomers(@PathVariable int customerId) {
        Customer theCustomer = customerService.getCustomer(customerId);

        if (theCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }

        return theCustomer;
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer theCustomer) {
        theCustomer.setId(0);

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") int customerId) {

        Customer tempCustomer = customerService.getCustomer(customerId);

        if (tempCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        } else {

            customerService.deleteCustomer(customerId);

            return "Deleted customer id - " + customerId;
        }
    }


}
