package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverCurrencyController {
    @GetMapping("/")
    public String showFormConvert() {
        return "index";
    }

    @PostMapping("/convertCurrency")
    public String convertCurrency(@RequestParam String usd, Model model) {
        model.addAttribute("usd", Integer.parseInt(usd)*23000);
        return "index";
    }
}
