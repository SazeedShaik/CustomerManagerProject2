package com.poc.microservices.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.poc.microservices.beans.Customer;
import com.poc.microservices.repository.Repo;


@RestController
public class CustomerController {
	@Autowired
	Repo repo;
	
	@GetMapping("/customer/")
	public List<Customer> getCustomer()	{
		return repo.findAll();
	}
	
	
	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") int id)	{
		return repo.findById(id); 
	}
	
	
	@PostMapping("/customer/")
	public String saveCustomer(@RequestBody Customer customer)	{
		repo.save(customer); 
		return "Customer is created successfully";
	}
	
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable("id") int id){
		Customer d= repo.getOne(id);
		repo.delete(d);
		return "Customer is deleted successfully";
	}
	
	
	@PutMapping(path="/customer/{id}", consumes = {"application/json"})
	public String updateCustomer(@RequestBody Customer customer)	{
		repo.save(customer);
		return "Customer is updated successfully";
	}
}
