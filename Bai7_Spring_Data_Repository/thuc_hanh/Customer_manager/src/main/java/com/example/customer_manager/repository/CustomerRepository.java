package com.example.customer_manager.repository;

import com.example.customer_manager.model.Customer;
import com.example.customer_manager.model.Province;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories("com.example.customer_manager.repository")
@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findByAllProvince(Province province);
}
