package com.example.blog_v2.service;

import com.example.blog_v2.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    public List<Blog> findAll();

    public Page<Blog> findAllBlog(Pageable pageable);

    public Page<Blog> findAllByContent(String name, Pageable pageable);

    public Page<Blog> findAllByTopic(Long id, Pageable pageable);

    Blog getBlogById(Long id);

    public Blog save(Blog blog);
}
