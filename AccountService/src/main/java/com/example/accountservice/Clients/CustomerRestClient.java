package com.example.accountservice.Clients;

import com.example.accountservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")

public interface CustomerRestClient
{
    @GetMapping("/customer/{id}")
    @CircuitBreaker(name = "CustomerCircuit",fallbackMethod = "DefaultCustomer")
    Customer FindCustomerByID(@PathVariable Long id);
    @GetMapping("/customers")
    @CircuitBreaker(name = "CustomerCircuit",fallbackMethod = "DefaultListCustomer")
    List<Customer> AllCustomers();
    default  Customer DefaultCustomer(Long id,Exception exception)
    {
        Customer customer=new Customer();
        customer.setFirstName("Customer Not avaliable");
        customer.setLastName("Customer Not avaliable");
        return customer;
    }
    default  List<Customer> DefaultListCustomer(Exception exception)
    {return List.of();}
}
