package com.example.exceptionhandler.repository;

import com.example.exceptionhandler.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {
}