package com.example.accountservice.entities;

import com.example.accountservice.enums.Account_Type;
import com.example.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class Account {
    @Id
    private String AccountId;
    private Date Date_Creation;
    private String currency;
    private Long Balance;
    @Enumerated(EnumType.STRING)
    private Account_Type type;
    @Transient
    private Customer customer;
    private Long CustomerId;
}
