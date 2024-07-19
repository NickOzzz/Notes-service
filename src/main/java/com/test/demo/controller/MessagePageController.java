package com.test.demo.controller;

import com.test.demo.dto.MessageDto;
import com.test.demo.service.IMessageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("panel")
public class MessagePageController {

    private IMessageService messageService;

    @Autowired
    public MessagePageController(IMessageService messageService)
    {
        this.messageService = messageService;
    }

    @GetMapping
    public String OpenPanel(Model model)
    {
        var messages = messageService.getAllMessages();

        model.addAttribute("messages", messages);
        model.addAttribute("messageDto", new MessageDto());

        return "getMessage";
    }
}
