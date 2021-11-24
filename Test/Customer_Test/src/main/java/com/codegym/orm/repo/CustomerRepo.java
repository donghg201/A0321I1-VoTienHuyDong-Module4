package com.codegym.orm.repo;

import com.codegym.orm.model.Customer;

public interface CustomerRepo {
    public Customer findById(Long id);

    public boolean saveCustomer(Customer customer);

    public boolean removeCustomer(Customer customer);
}
