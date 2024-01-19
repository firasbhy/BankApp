package com.example.accountservice.web;

import com.example.accountservice.Clients.CustomerRestClient;
import com.example.accountservice.entities.Account;
import com.example.accountservice.models.Customer;
import com.example.accountservice.repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private AccountRepository ar;
    private CustomerRestClient customerRestClient;

    public AccountRestController(AccountRepository ar, CustomerRestClient customerRestClient) {
        this.ar = ar;
        this.customerRestClient=customerRestClient;
    }
    @GetMapping("Accounts")
    public List<Account> AccountList()
    {
       List<Account> accounts =this.ar.findAll();
       accounts.forEach(c->{
          Customer customer =customerRestClient.FindCustomerByID(c.getCustomerId());
          c.setCustomer(customer);
       });
       return accounts;
    }
    @GetMapping("Accounts/{id}")
    public Account getAccount(@PathVariable String id)
    {
        Account a= this.ar.findById(id).get();
        Customer c= this.customerRestClient.FindCustomerByID(a.getCustomerId());
        a.setCustomer(c);
        return  a;
    }
}
