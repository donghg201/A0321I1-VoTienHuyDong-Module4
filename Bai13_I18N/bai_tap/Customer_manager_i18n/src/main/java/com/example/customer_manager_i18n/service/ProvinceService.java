package com.example.customer_manager_i18n.service;

import com.example.customer_manager_i18n.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}