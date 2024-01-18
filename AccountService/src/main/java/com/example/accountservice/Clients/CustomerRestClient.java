package com.example.accountservice.Clients;

import com.example.accountservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient
{
    @GetMapping("/customer/{id}")
    Customer FindCustomerByID(@PathVariable Long id);
    @GetMapping("/customers")
    List<Customer> AllCustomers();
}
