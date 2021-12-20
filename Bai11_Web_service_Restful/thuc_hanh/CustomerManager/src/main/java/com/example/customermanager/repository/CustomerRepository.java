package com.example.customermanager.repository;

import com.example.customermanager.model.Customer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRepository extends Repository<Customer> {
}
