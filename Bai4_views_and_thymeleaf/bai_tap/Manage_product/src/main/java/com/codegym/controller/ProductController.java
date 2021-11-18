package com.codegym.controller;

import com.codegym.model.Product;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.HashMap;
import java.util.Map;

public class ProductController {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product("A", "IP5", 10, "None"));
        productMap.put(2, new Product("B", "IP6", 10, "None"));
        productMap.put(3, new Product("C", "IP7", 10, "None"));
        productMap.put(4, new Product("D", "IP8", 10, "None"));
        productMap.put(5, new Product("E", "IPX", 10, "None"));
    }

    @GetMapping("/index")
    public String form(Model model) {
        model.addAttribute("product", productMap);
        return "index";
    }

    @PostMapping("/result")
    public String settingResult(Model model, @ModelAttribute Product product) {
        model.addAttribute("product", product);
        return "result";
    }
}
