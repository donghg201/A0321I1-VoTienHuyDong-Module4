package com.example.blog_v2.service;

import com.example.blog_v2.model.Blog;
import com.example.blog_v2.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Blog getBlogById(Long id) {
        return blogRepository.getBlogById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

}
