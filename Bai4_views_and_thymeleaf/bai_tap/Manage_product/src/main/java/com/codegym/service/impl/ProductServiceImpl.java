package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> productMap;
    static {
        productMap =new HashMap<>();
        productMap.put(1, new Product(1, "IP6", 10, "Hanoi"));
        productMap.put(2, new Product(2, "IP7", 10, "Danang"));
        productMap.put(3, new Product(3, "IP8", 10 ,"Saigon"));
        productMap.put(4, new Product(4, "IPX", 10, "Beijin"));
        productMap.put(5, new Product(5, "IP11", 10, "Miami"));
        productMap.put(6, new Product(6, "IP12", 10, "Newyork"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove((id));
    }
}
