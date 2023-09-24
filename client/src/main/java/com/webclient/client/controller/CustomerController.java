package com.webclient.client.controller;

import com.webclient.client.DTO.Customer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class CustomerController {

    WebClient webClient;

    public CustomerController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/customers")
    public Flux<Customer> getCustomers() {
        Flux<Customer> fluxOfCustomer = webClient.get()
                .uri("/customers")
                .retrieve()
                .bodyToFlux(Customer.class)
                .delayElements(Duration.ofSeconds(1));

        System.out.println("Hello from getCustomer()");

        fluxOfCustomer.subscribe(customer -> System.out.println(customer.toString()));

        return fluxOfCustomer;
    }

    @GetMapping("/customers/{customerId}")
    public Mono<Customer> getCustomers(@PathVariable int customerId) {
        return webClient.get()
                .uri("/customers/" + customerId)
                .retrieve()
                .bodyToMono(Customer.class)
                .delayElement(Duration.ofSeconds(3));
    }

    @PostMapping("/customers")
    public Mono<Customer> saveCustomer(@RequestBody Customer theCustomer) {

        return webClient.post()
                .uri("/customers")
                .syncBody(theCustomer)
                .retrieve()
                .bodyToMono(Customer.class);
    }

    @PutMapping("/customers")
    public Mono<Customer> updateCustomer(@RequestBody Customer theCustomer) {
        return webClient.put()
                .uri("/customers")
                .syncBody(theCustomer)
                .retrieve()
                .bodyToMono(Customer.class);
    }

    @DeleteMapping("/customers/{customerId}")
    public Mono<String> deleteCustomer(@PathVariable("customerId") int customerId) {
        return webClient.delete()
                .uri("/customers/" + customerId)
                .retrieve()
                .bodyToMono(String.class);
    }
}
