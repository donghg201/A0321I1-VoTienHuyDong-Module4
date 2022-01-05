package com.example.casestudy.service;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    public Page<Customer> findAllCustomer(Pageable pageable);

    public Page<Customer> findAllByName(String name, Pageable pageable);

//    public Page<Customer> findAllByTopic(Long id, Pageable pageable);

    Customer getCustomerById(Integer id);

    public Customer save(Customer customer);

    public void deleteCustomerById(int id);
}
