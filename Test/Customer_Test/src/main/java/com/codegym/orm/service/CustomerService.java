package com.codegym.orm.service;

import com.codegym.orm.model.Customer;
import com.codegym.orm.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public interface CustomerService {
    public Customer findById(Long id);

    public Boolean saveCustomer(Customer customer);

    public Boolean removeCustomer(Customer customer);
}
