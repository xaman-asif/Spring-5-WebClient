package com.webclient.provider.service.implementation;

import com.webclient.provider.model.Customer;
import com.webclient.provider.repository.CustomerRepository;
import com.webclient.provider.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        return customerRepository.findById(theId).orElse(null);
    }

    @Override
    public void deleteCustomer(int theId) {
        customerRepository.deleteById(theId);
    }
}
