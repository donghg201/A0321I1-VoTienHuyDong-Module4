package com.codegym.orm.repository;

import com.codegym.orm.model.Customer;
import com.codegym.orm.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
