package com.example.store.root;

import com.example.store.product_category.ProductCategory;
import com.example.store.product_category.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class RootController {

    private final ProductCategoryService productCategoryService;

    @GetMapping({"/","/index"})
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/gdpr")
    public String gDPR() {
        return "/documents/gdpr";
    }

    @RequestMapping("/payment_methods")
    public String paymentMethod() {
        return "/documents/paymeth";
    }

    @RequestMapping("/cookies_policy")
    public String cookiesPolicy() {
        return "/documents/cookpol";
    }

    @RequestMapping("/privacy_policy")
    public String privacyPolicy() {
        return "/documents/privpol";
    }

    @RequestMapping("/404")
    public String nothingFound() {
        return "404";
    }

}