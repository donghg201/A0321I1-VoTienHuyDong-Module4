package com.example.blog_v4.controller;

import com.example.blog_v4.model.Blog;
import com.example.blog_v4.repository.BlogRepository;
import com.example.blog_v4.repository.TopicRepository;
import com.example.blog_v4.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


//@RestController
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    BlogRepository blogRepository;

//    @PostMapping("/api/blog/create")
//    public ResponseEntity<Void> createBook(@RequestBody Blog blog) {
//        blogService.save(blog);
//        return new ResponseEntity(HttpStatus.CREATED);
//    }
//
//    @GetMapping("/api/blog/list")
//    public ResponseEntity<List<Blog>> getListBlog() {
//        List<Blog> blogList = blogService.findAll();
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }
//
//    @PutMapping("/api/blog/edit/{id}")
//    public ResponseEntity<Blog> editBlog(@PathVariable Long id, @RequestBody Blog blog) {
//        Blog blog1 = blogService.getBlogById(id).orElse(null);
//        blog1.setContent(blog.getContent());
//        blog1.setTitle(blog.getTitle());
//        blog1.setTopic(blog.getTopic());
//
//        blogService.save(blog1);
//        return new ResponseEntity<Blog>(blog1, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/api/blog/delete/{id}")
//    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") Long id) {
//        Blog blog = blogService.getBlogById(id).orElse(null);
//        blogRepository.delete(blog);
//        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
//    }


    @GetMapping("/list")
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
        return "/blog/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model, @PageableDefault(size = 3) Pageable pageable) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("topicList", topicRepository.findAll());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute("blog") Blog blog, Model model, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        model.addAttribute("blog", new Blog());
        redirectAttributes.addFlashAttribute("message", "New blog created successfully");
        return "redirect:/blog/list";
    }

    @GetMapping("/edit-blog/{id}")
    public String updateBlog(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("topicList", topicRepository.findAll());
        model.addAttribute("blog", blog);
        return "/blog/edit";
    }

    @PostMapping("/edit-blog")
    public String updateBlog(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.save(blog);
        model.addAttribute("blog", new Blog());
        model.addAttribute("message", "New blog created successfully");
        return "/blog/edit";
    }

    @GetMapping("/delete-blog/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "/blog/delete";
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogRepository.deleteById(blog.getId());
        return "redirect:/blog/list";
    }

    @GetMapping("/detail/{id}")
    public String detailBlog(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "/blog/detail";
    }
}
