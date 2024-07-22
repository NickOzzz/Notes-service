package com.test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DefaultRedirectController {
    @GetMapping
    public RedirectView RedirectToMainPage()
    {
        return new RedirectView("/panel");
    }
}
