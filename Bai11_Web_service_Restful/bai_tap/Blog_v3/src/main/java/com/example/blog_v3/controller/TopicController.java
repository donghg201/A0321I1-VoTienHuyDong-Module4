package com.example.blog_v3.controller;

import com.example.blog_v3.model.Blog;
import com.example.blog_v3.model.Topic;
import com.example.blog_v3.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    TopicRepository topicRepository;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("topics", topicRepository.findAll());
        return "/topic/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("topic", new Topic());
        return "/topic/create";
    }

    @PostMapping("/create")
    public String saveTopic(@ModelAttribute("topic") Topic topic, Model model) {
        topicRepository.save(topic);
        model.addAttribute("blog", new Blog());
        model.addAttribute("message", "New blog created successfully");
        return "/topic/create";
    }

    @GetMapping("/edit-topic/{id}")
    public String updatetopic(@PathVariable("id") Long id, Model model) {
        Topic topic = topicRepository.getById(id);
        model.addAttribute("topic", topic);
        return "/topic/edit";
    }

    @PostMapping("/edit-topic")
    public String updateTopic(@ModelAttribute("topic") Topic topic, Model model) {
        topicRepository.save(topic);
        model.addAttribute("topic", new Topic());
        model.addAttribute("message", "New topic created successfully");
        return "/topic/edit";
    }

    @GetMapping("/delete-topic/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Topic topic = topicRepository.getById(id);
        model.addAttribute("topic", topic);
        return "/topic/delete";
    }

    @PostMapping("/delete-topic")
    public String deleteTopic(@ModelAttribute("customer") Topic topic) {
        topicRepository.deleteById(topic.getId());
        return "redirect:/topic/list";
    }

    @GetMapping("/detail/{id}")
    public String detailTopic(@PathVariable("id") Long id, Model model) {
        Topic topic = topicRepository.getById(id);
        model.addAttribute("topic", topic);
        return "/topic/detail";
    }
}
