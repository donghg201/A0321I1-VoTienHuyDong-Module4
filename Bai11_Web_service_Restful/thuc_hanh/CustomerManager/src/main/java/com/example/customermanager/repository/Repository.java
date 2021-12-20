package com.example.customermanager.repository;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Repository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}

