package com.test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class MessageErrorController {
    @GetMapping
    public String ErrorResponse()
    {
        return "error";

    }
}
