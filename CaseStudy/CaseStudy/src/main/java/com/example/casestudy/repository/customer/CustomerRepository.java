package com.example.casestudy.repository.customer;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from case_study_module4.customer where customer.customer_name like %:name%", nativeQuery = true)
    Page<Customer> findAllByCustomer_nameContaining(String name, Pageable pageable);
//    @Query(value = "delete from case_study_module4.customer where customer.customer_id = :id", nativeQuery = true)
//    Customer deleteCustomerByCustomer_id(Integer id);
}
