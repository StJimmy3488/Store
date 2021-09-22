package com.example.store.root;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;
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