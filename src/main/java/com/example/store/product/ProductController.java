package com.example.store.product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @GetMapping("/all_products")
    public String getAllProducts(Model model) {
        model.addAttribute("all_products", productService.findAllProducts());
        return "/products/all_products";
    }

}
