package com.codegym.orm.service;

import com.codegym.orm.model.Customer;
import com.codegym.orm.model.Province;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}