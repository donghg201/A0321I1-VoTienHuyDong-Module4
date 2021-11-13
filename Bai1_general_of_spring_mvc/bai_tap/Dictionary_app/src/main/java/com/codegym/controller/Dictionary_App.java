package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dictionary_App {
    @GetMapping("/")
    public String formDictionary() {
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String eng, Model model) {
        switch (eng) {
            case "Hello":
                model.addAttribute("vie", "Xin chao");
                break;
            case "What":
                model.addAttribute("vie", "Cai gi");
                break;
            case "Why":
                model.addAttribute("vie", "Tai sao");
                break;
            case "How":
                model.addAttribute("vie", "The nao");
                break;
            case "When":
                model.addAttribute("vie", "Khi nao");
                break;
            case "Which":
                model.addAttribute("vie", "Cai nao");
                break;
            case "Where":
                model.addAttribute("vie", "O dau");
                break;
            default:
                model.addAttribute("vie", "Khong the dich");
        }
        return "index";
    }
}
