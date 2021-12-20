package com.example.blog_v3.service;

import com.example.blog_v3.model.Blog;
import com.example.blog_v3.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByContent(String name, Pageable pageable) {
        return blogRepository.findAllByContentContaining(name, pageable);
    }

    @Override
    public Page<Blog> findAllByTopic(Long id, Pageable pageable) {
        return blogRepository.findAllByTopic(id, pageable);
    }

    @Override
    public Optional<Blog> getBlogById(Long id) {
        return Optional.ofNullable(blogRepository.getBlogById(id));
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

}
