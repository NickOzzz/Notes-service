package com.test.demo.controller;

import com.test.demo.dto.*;
import com.test.demo.exception.MessageNotFoundException;
import com.test.demo.service.IMessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import com.test.demo.event.IMessageEvent;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    public IMessageService messageService;

    @Autowired
    public MessageController(IMessageService messageService)
    {
        this.messageService = messageService;
    }

    @PostMapping("/panel/create")
    public RedirectView generateMessageFromPanel(@Valid MessageDto message, BindingResult result)
    {
        if (result.hasErrors()) {
            return new RedirectView("/panel");
        }

        generateMessage(message);
        return new RedirectView("/panel");
    }

    @PostMapping("/panel/update")
    public RedirectView updateMessageFromPanel(@Valid MessageDto message, BindingResult result)
    {
        if (result.hasErrors()) {
            return new RedirectView("/panel");
        }

        updateMessage(message);
        return new RedirectView("/panel");
    }

    @PostMapping("/panel/delete")
    public RedirectView deleteMessageFromPanel(@RequestParam String messageId)
    {
        deleteMessage(messageId);
        return new RedirectView("/panel");
    }

    @PostMapping
    public ResponseEntity<String> generateMessage(@RequestBody MessageDto message)
    {
        message.setTime(new Date(System.currentTimeMillis()).toString());
        IMessageEvent response = messageService.createMessage(message);
        return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateMessage(@RequestBody MessageDto message)
    {
        message.setTime(new Date(System.currentTimeMillis()).toString());
        IMessageEvent response = messageService.updateMessage(message);
        return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);
    }

    @DeleteMapping("/{messageId}")
    public ResponseEntity<String> deleteMessage(@PathVariable String messageId)
    {
        IMessageEvent response = messageService.deleteMessage(messageId);
        return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);
    }

    @GetMapping("/{messageId}")
    public ResponseEntity<MessageDto> getMessage(@PathVariable String messageId)
            throws MessageNotFoundException
    {
        IDto response = messageService.getMessage(messageId);
        return new ResponseEntity<MessageDto>((MessageDto)response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MessageDto>> getAllMessages()
    {
        List<MessageDto> response = messageService.getAllMessages();

        return new ResponseEntity<List<MessageDto>>(response, HttpStatus.OK);
    }
}
