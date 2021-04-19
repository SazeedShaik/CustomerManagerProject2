package com.poc.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.poc.microservices.beans.Customer;

public interface Repo extends JpaRepository<Customer, Integer>{

}
