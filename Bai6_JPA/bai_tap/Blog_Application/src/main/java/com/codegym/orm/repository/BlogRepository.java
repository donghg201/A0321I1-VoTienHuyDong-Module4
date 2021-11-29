package com.codegym.orm.repository;

import com.codegym.orm.model.Blog;

import java.util.List;

public interface BlogRepository {
    Blog getBlogById(Long id);
    List<Blog> getList();
    void save(Blog blog);
    void update(Blog blog);
    void delete(Long id);
}
