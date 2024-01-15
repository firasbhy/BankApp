package com.example.customerservice.repositories;

import com.example.customerservice.entities.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CostumerRepository extends JpaRepository<Costumer,Long> {
}
