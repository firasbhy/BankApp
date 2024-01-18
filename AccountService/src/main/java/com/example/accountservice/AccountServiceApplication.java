package com.example.accountservice;

import com.example.accountservice.entities.Account;
import com.example.accountservice.enums.Account_Type;
import com.example.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository ar)
    { return args -> {
        Account a1=  Account.builder().
                   AccountId(UUID.randomUUID().toString()).Balance(20000000L).type(Account_Type.CURRENT_ACCOUNT)
                .CustomerId(Long.valueOf(2)).build();
        Account a2=  Account.builder().
                AccountId(UUID.randomUUID().toString()).Balance(3500000L).type(Account_Type.SAVING_ACCOUNT)
                .CustomerId(Long.valueOf(1)).build();
        ar.save(a1);
        ar.save(a2);

    };
    }

    }
