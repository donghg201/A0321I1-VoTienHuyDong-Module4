package com.example.flowersshop.service;

import com.example.flowersshop.model.Product;

public interface ProductService {
    Iterable<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);
}
