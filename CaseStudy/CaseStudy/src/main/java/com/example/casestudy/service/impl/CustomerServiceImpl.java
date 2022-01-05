package com.example.casestudy.service.impl;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.repository.customer.CustomerRepository;
import com.example.casestudy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByName(String name, Pageable pageable) {
        return customerRepository.findAllByCustomer_nameContaining(name, pageable);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }
}
