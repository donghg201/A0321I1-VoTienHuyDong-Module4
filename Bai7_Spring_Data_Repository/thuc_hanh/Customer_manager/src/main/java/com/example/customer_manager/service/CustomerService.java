package com.example.customer_manager.service;

import com.example.customer_manager.model.Customer;
import com.example.customer_manager.model.Province;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface CustomerService {

    public Iterable<Customer> findAll();

    public Customer findById(Long id);

    public void save(Customer customer);

    public void remove(Long id);

}