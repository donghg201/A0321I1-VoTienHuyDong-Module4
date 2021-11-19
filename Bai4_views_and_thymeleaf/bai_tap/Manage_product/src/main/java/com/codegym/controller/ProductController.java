package com.codegym.controller;

import com.codegym.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("A", "IP5", 10, "None"));
        productList.add(new Product("B", "IP6", 10, "None"));
        productList.add(new Product("C", "IP7", 10, "None"));
        productList.add(new Product("D", "IP8", 10, "None"));
        productList.add(new Product("E", "IPX", 10, "None"));
    }

    @GetMapping("/")
    public String form(Model model) {
        model.addAttribute("productList", productList);
        return "index";
    }
}
