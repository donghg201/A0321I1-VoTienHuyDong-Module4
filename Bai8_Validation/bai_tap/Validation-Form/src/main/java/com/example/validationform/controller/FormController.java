package com.example.validationform.controller;

import com.example.validationform.model.User;
import com.example.validationform.service.UserRepository;
import com.example.validationform.validator.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/")
    public String checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        new FormValidator().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            userRepository.save(user);
            model.addAttribute("user", userRepository.getUserById(1));
            return "result";
        }
    }
}
