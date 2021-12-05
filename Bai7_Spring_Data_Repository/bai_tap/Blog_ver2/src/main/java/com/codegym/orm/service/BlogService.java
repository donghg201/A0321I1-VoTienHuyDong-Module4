package com.codegym.orm.service;

import com.codegym.orm.model.Blog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlogService {
    Blog getBlogById(long id);

    List<Blog> getList();

    void save(Blog blog);

    void remove(Blog blog);

    void deleteBlogById(long id);
}
