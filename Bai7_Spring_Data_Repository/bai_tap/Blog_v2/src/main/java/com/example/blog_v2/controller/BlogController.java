package com.example.blog_v2.controller;

import com.example.blog_v2.model.Blog;
import com.example.blog_v2.model.Topic;
import com.example.blog_v2.repository.BlogRepository;
import com.example.blog_v2.repository.TopicRepository;
import com.example.blog_v2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    BlogRepository blogRepository;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(size = 3) Pageable pageable,
                           Optional<String> key_search,
                           Optional<Long> topicId) {
        model.addAttribute("topicList", topicRepository.findAll());
        if (key_search.isPresent()) {
            model.addAttribute("blogs", blogService.findAllByContent(key_search.get(), pageable));
        } else {
            if (topicId.isPresent()) {
                model.addAttribute("blogs", blogService.findAllByTopic(topicId.get(), pageable));
            } else {
                model.addAttribute("blogs", blogService.findAllBlog(pageable));
            }
        }
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model, @PageableDefault(size = 3) Pageable pageable) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("topicList", topicRepository.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.save(blog);
        model.addAttribute("blog", new Blog());
        model.addAttribute("message", "New blog created successfully");
        return "create";
    }

    @GetMapping("/edit-blog/{id}")
    public String updateBlog(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("topicList", topicRepository.findAll());
        model.addAttribute("blog", blog);
        return "edit";
    }

    @PostMapping("/edit-blog")
    public String updateBlog(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.save(blog);
        model.addAttribute("blog", new Blog());
        model.addAttribute("message", "New blog created successfully");
        return "edit";
    }

    @GetMapping("/delete-blog/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "delete";
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("customer") Blog blog) {
        blogRepository.deleteById(blog.getId());
        return "redirect:";
    }
}
