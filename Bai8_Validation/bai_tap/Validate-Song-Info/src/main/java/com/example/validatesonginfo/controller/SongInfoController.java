package com.example.validatesonginfo.controller;

import com.example.validatesonginfo.model.SongInfo;
import com.example.validatesonginfo.repository.SongInfoRepository;
import com.example.validatesonginfo.validator.SongValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class SongInfoController {
    @Autowired
    SongInfoRepository songInfoRepository;

    @Autowired
    SongValidator songValidator;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("songs", songInfoRepository.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("song", new SongInfo());
        return "create";
    }

    @PostMapping("/create")
    public String saveSong(@Validated @ModelAttribute("song") SongInfo songInfo, BindingResult bindingResult, Model model) {
        songValidator.validate(songInfo, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            songInfoRepository.save(songInfo);
            model.addAttribute("song", new SongInfo());
            model.addAttribute("message", "New song created successfully");
            return "create";
        }
    }

    @GetMapping("/edit-song/{id}")
    public String updateBlog(@PathVariable("id") Integer id, Model model) {
        SongInfo songInfo = songInfoRepository.getById(id);
        model.addAttribute("song", songInfo);
        return "edit";
    }

    @PostMapping("/edit-song")
    public String updateBlog(@Validated @ModelAttribute("song") SongInfo songInfo, BindingResult bindingResult, Model model) {
        songValidator.validate(songInfo, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            songInfoRepository.save(songInfo);
            model.addAttribute("song", new SongInfo());
            model.addAttribute("message", "New blog created successfully");
            return "edit";
        }
    }
}
