package com.example.customer_manager.repository;


import com.example.customer_manager.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}