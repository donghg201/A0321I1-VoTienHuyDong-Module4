package com.example.blogmrsnga.service;


import com.example.blogmrsnga.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    Category getCategoryById(int id);

    void save(Category category);

    void deleteCategoryById(int id);

}