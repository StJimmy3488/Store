package com.example.store.product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/products")

public class ProductController {

    @GetMapping("/all_products")
    public String getAllProducts() {

        return "/products/all_products";
    }



}
