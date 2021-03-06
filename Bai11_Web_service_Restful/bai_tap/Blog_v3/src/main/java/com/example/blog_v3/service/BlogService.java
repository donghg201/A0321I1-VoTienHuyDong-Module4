package com.example.blog_v3.service;

import com.example.blog_v3.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    public List<Blog> findAll();

    public Page<Blog> findAllBlog(Pageable pageable);

    public Page<Blog> findAllByContent(String name, Pageable pageable);

    public Page<Blog> findAllByTopic(Long id, Pageable pageable);

    Optional<Blog> getBlogById(Long id);

    public Blog save(Blog blog);
}
