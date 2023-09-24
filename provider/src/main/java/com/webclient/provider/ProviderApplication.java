package com.webclient.provider;

import com.webclient.provider.model.Customer;
import com.webclient.provider.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProviderApplication {
	@Autowired
	CustomerRepository customerRepository;

	@PostConstruct
	public void insertSomeCustomerData() {
		Customer customer1 = new Customer(1,"John", "Doe", "john@example.com");
		Customer customer2 = new Customer(2,"Jane", "Doe", "jane@example.com");
		Customer customer3 = new Customer(3,"Tom", "Smith", "tom@example.com");
		Customer customer4 = new Customer(4,"Sarah", "Davis", "sarah@example.com");
		Customer customer5 = new Customer(5,"David", "Wilson", "davids@example.com");


		List<Customer> listOfCustomers = List.of(customer1, customer2, customer3, customer4, customer5);

		customerRepository.saveAll(listOfCustomers);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}

}