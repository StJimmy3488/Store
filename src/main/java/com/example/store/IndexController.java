package com.example.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/home")
    public String homePage() {
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