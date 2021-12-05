package com.codegym.orm.controller;

import com.codegym.orm.model.Blog1;
import com.codegym.orm.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @Autowired
    private BlogRepo blogRepo;
    @GetMapping("/hello")
    public void show(){
        System.out.println("a");
        blogRepo.save(new Blog1());
    }
}
