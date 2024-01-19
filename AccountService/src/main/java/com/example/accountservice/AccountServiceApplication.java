package com.example.accountservice;

import com.example.accountservice.Clients.CustomerRestClient;
import com.example.accountservice.entities.Account;
import com.example.accountservice.enums.Account_Type;
import com.example.accountservice.models.Customer;
import com.example.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository ar, CustomerRestClient cr)
    {
        return args -> {

       List<Customer> customers=cr.AllCustomers();
         customers.forEach(customer -> {
             Account a1=  Account.builder().
                     AccountId(UUID.randomUUID().toString()).Balance((long) (Math.random()*5345)).type(Account_Type.CURRENT_ACCOUNT)
                     .CustomerId(customer.getId()).build();
             ar.save(a1);
             Account a2=  Account.builder().
                     AccountId(UUID.randomUUID().toString()).Balance((long) (Math.random()*7200)).type(Account_Type.SAVING_ACCOUNT)
                     .CustomerId(customer.getId()).build();

             ar.save(a2);
         });



    };
    }

    }
