package com.example.Palvelinohjelmointi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;	
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Palvelinohjelmointi.domain.Customer;
import com.example.Palvelinohjelmointi.domain.CustomerDAOImpl;

@SpringBootApplication
public class CustomerListJDBC {
	private static final Logger log = LoggerFactory.getLogger(CustomerListJDBC.class);

	public static void main(String[] args) {
		SpringApplication.run(CustomerListJDBC.class, args);
	}
	   
	@Bean
	public CommandLineRunner demo(CustomerDAOImpl customerDAO) {
		return (args) -> {
			// Database is created by using resources/schema.sql
			
			// Insert some demo data
			//jdbcTemplate.execute("INSERT")
	        customerDAO.save(new Customer("John", "Doe"));
	        customerDAO.save(new Customer("Matti", "Meikäläinen"));
	        customerDAO.save(new Customer("Firstname", "Lastname"));
	       
		};
	}	
}