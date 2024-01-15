package com.example.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(com.example.customerservice.repositories.CostumerRepository cr)
	{ return args -> {




		com.example.customerservice.entities.Costumer c1= com.example.customerservice.entities.Costumer.builder()
				.FirstName("firas")
				.LastName("haj yedder")
				.Email("firas@gmail.com")
				.build()
				;
		cr.save(c1);
		com.example.customerservice.entities.Costumer c2= com.example.customerservice.entities.Costumer.builder()
				.FirstName("wissal")
				.LastName("bghouri")
				.Email("wissal@gmail.com")
				.build();
		cr.save(c2);
	};

	}

}
