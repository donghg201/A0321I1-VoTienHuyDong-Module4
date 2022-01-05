package com.example.casestudy.repository;

import com.example.casestudy.model.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
