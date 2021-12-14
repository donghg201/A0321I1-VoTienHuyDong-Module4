package com.example.borrowbookapp.controller;

import com.example.borrowbookapp.model.Library;
import com.example.borrowbookapp.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @GetMapping("/list")
    public String showList(Model model, @PageableDefault(size = 5) Pageable pageable,
                           Optional<String> key_search) {
//        model.addAttribute("bookList", libraryService.findAll());
//        if (key_search.isPresent()) {
//            model.addAttribute("blogs", blogService.findAllByContent(key_search.get(), pageable));
//        } else {
//            if (topicId.isPresent()) {
//                model.addAttribute("blogs", blogService.findAllByTopic(topicId.get(), pageable));
//            } else {
        model.addAttribute("bookList", libraryService.findAllBook(pageable));
//            }
//        }
        return "/library/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("library", new Library());
        return "/library/create";
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute("blog") Library library, Model model) {
        libraryService.save(library);
        model.addAttribute("library", new Library());
        model.addAttribute("message", "New book created successfully");
        return "/library/create";
    }

    @GetMapping("/edit-book/{id}")
    public String updateBlog(@PathVariable("id") int id, Model model) {
        Library library = libraryService.getBookById(id);
        model.addAttribute("library", library);
        return "/library/edit";
    }

    @PostMapping("/edit-book")
    public String updateBlog(@ModelAttribute("library") Library library, Model model) {
        libraryService.save(library);
        model.addAttribute("blog", new Library());
        model.addAttribute("message", "New book created successfully");
        return "/library/edit";
    }

    @GetMapping("/delete-book/{id}")
    public String showDeleteForm(@PathVariable int id, Model model) {
        Library library = libraryService.getBookById(id);
        model.addAttribute("library", library);
        return "/library/delete";
    }

    @PostMapping("/delete-book")
    public String deleteBlog(@ModelAttribute("library") Library library) {
        libraryService.deleteBookById(library.getId());
        return "redirect:/library/list";
    }
}
