package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping("")
    public String show() {
        return "result";
    }

    @PostMapping("/result")
    public String result(@RequestParam Double number1, Double number2, String asmd, Model model) {
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("asmd", asmd);
        switch (asmd) {
            case "addition":
                model.addAttribute("result", number1 + number2);
                model.addAttribute("name", "Addition");
                break;
            case "subtraction":
                model.addAttribute("result", number1 - number2);
                model.addAttribute("name", "Subtraction");
                break;
            case "multiplication":
                model.addAttribute("result", number1 * number2);
                model.addAttribute("name", "Multiplication");
                break;
            case "division":
                model.addAttribute("result", number1 / number2);
                model.addAttribute("name", "Division");
                break;
            default:
                return "";
        }
        return "result";
    }
}
