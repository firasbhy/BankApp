package com.example.customerservice.web;

import com.example.customerservice.entities.Costumer;
import com.example.customerservice.repositories.CostumerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CostumerRestController {
    private CostumerRepository cr;

    public CostumerRestController(CostumerRepository cr) {
        this.cr = cr;
    }
@GetMapping("/customers")
  public  List<Costumer> customerlist()
    {
        return this.cr.findAll();
    }
    @GetMapping("/customers/{id}")
    public  Costumer getCostumer(@PathVariable Long id)
    {
        return  this.cr.findById(id).get();
    }
}
