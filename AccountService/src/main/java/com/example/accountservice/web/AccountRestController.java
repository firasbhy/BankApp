package com.example.accountservice.web;

import com.example.accountservice.entities.Account;
import com.example.accountservice.repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private AccountRepository ar;

    public AccountRestController(AccountRepository ar) {
        this.ar = ar;
    }
    @GetMapping("Accounts")
    public List<Account> AccountList()
    {
       return  this.ar.findAll();
    }
    @GetMapping("Accounts/{id}")
    public Account getAccount(@PathVariable String id)
    {
        return this.ar.findById(id).get();
    }
}
