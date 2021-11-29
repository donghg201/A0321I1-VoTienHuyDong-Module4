package com.codegym.orm.service;

import com.codegym.orm.model.Blog;
import com.codegym.orm.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.getBlogById(id);
    }

    @Override
    public List<Blog> getList() {
        return blogRepository.getList();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.update(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.delete(id);
    }
}
