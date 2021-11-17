package com.codegym.controller;

import com.codegym.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VirtualMailController {
    @GetMapping("/index")
    public String form(Model model) {
        model.addAttribute("setting", new Setting());
        String[] langueges = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        model.addAttribute("selectLanguage", langueges);
        int[] pageSize = new int[]{5, 10, 15, 25, 50, 100};
        model.addAttribute("selectPageSize", pageSize);
        return "index";
    }

    @PostMapping("/result")
    public String settingResult(Model model, @ModelAttribute Setting setting) {
        model.addAttribute("setting", setting);
        return "result";
    }
}
