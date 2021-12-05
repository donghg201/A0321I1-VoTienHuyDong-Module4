package com.codegym.orm.controller;

import com.codegym.orm.model.Blog;
import com.codegym.orm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
public class BlogController {
    @Autowired
    BlogService blogService;

//    @Autowired
//    private TopicService topicService;

//    @ModelAttribute("topics")
//    public List<Topic> topics(){
//        return topicService.findAll();
//    }

//    private String[] topicList = {"Education", "Media", "Entertainment", "Pharmacy", "Other"};

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.save(blog);
        return "redirect:blog/list";
    }

    @GetMapping("/list")
    public String listBlogs(Model model) {
        model.addAttribute("blogs", blogService.getList());
        return "blog/list";
    }

//    @GetMapping("/edit-blog/{id}")
//    public String showEditForm(@PathVariable Long id, Model model) {
//        Blog blog = blogService.getBlogById(id);
//        if (blog != null) {
//            ModelAndView modelAndView = new ModelAndView("/blog/edit");
//            modelAndView.addObject("blog", blog);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit-blog")
//    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
//        blogService.save(blog);
//        ModelAndView modelAndView = new ModelAndView("/blog/edit");
//        modelAndView.addObject("blog", blog);
//        modelAndView.addObject("message", "Blog updated successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/delete-blog/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id) {
//        Blog blog = blogService.getBlogById(id);
//        if (blog != null) {
//            ModelAndView modelAndView = new ModelAndView("/blog/delete");
//            modelAndView.addObject("blog", blog);
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete-blog")
//    public String deleteBlog(@ModelAttribute("customer") Blog blog) {
//        blogService.remove(blog);
//        return "redirect:list";
//    }
}
