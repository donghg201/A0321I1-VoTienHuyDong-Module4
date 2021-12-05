package com.codegym.orm.service;

import com.codegym.orm.model.Blog;
import com.codegym.orm.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;


    @Override
    public Blog getBlogById(long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> getList() {
        Iterable<Blog> iterable = blogRepository.findAll();
        List<Blog> blogList = new ArrayList<>();
        for(Blog blog: iterable){
            blogList.add(blog);
        }
        return blogList;
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public void deleteBlogById(long id) {
        blogRepository.deleteById(id);
    }
}
