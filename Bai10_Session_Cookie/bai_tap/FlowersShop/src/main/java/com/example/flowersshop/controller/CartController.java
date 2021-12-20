package com.example.flowersshop.controller;

import com.example.flowersshop.model.Cart;
import com.example.flowersshop.model.Product;
import com.example.flowersshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CartController {
    @Autowired
    ProductService productService;

    @GetMapping("buy")
    public String getCart(@SessionAttribute("carts") HashMap<Long, Cart> hashMap, Model model) {
        model.addAttribute("carts", hashMap);
        model.addAttribute("cartNum", hashMap.size());
        model.addAttribute("cartMoney", totalPrice(hashMap));
        return "cart";
    }

    @GetMapping("buy/{id}")
    public String addProductToCart(@PathVariable Long id, @SessionAttribute("carts") HashMap<Long, Cart> hashMap, Model model) {

        Product product = productService.findById(id);

        if (product != null) {
//            TH chưa có sản phẩm trong giỏ hàng
            if (!hashMap.containsKey(id)) {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                hashMap.put(id, item);
            } else {
//                TH Sản phẩm đã có trong giỏ hàng
                Cart item = hashMap.get(id);
                item.setQuantity(item.getQuantity() + 1);
                hashMap.put(id, item);
            }
        }
        model.addAttribute("carts", hashMap);
        model.addAttribute("cartNum", hashMap.size());
        model.addAttribute("cartMoney", totalPrice(hashMap));
        return "cart";
    }

    private double totalPrice(HashMap<Long, Cart> hashMap) {
        int count = 0;
        for (Map.Entry<Long, Cart> list : hashMap.entrySet()) {
            count += list.getValue().getProduct().getPrice() * list.getValue().getQuantity();
        }
        return count;
    }
}
