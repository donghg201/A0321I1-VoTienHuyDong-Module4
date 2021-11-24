package com.codegym.orm.service;

import com.codegym.orm.model.Customer;
import com.codegym.orm.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id);
    }

    @Override
    public Boolean saveCustomer(Customer customer) {
        return customerRepo.saveCustomer(customer);
    }

    @Override
    public Boolean removeCustomer(Customer customer) {
        return customerRepo.removeCustomer(customer);
    }
}
