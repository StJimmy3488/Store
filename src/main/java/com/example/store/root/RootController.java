package com.example.store.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {

    @GetMapping({"/","/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/gdpr")
    public String gDPR() {
        return "gdpr";
    }

    @RequestMapping("/payment_methods")
    public String paymentMethod() {
        return "paymeth";
    }

    @RequestMapping("/cookies_policy")
    public String cookiesPolicy() {
        return "cookpol";
    }

    @RequestMapping("/privacy_policy")
    public String privacyPolicy() {
        return "privpol";
    }

}