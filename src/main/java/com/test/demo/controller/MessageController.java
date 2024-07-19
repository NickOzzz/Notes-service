package com.test.demo.controller;

import com.test.demo.dto.*;
import com.test.demo.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    public RedirectView generateMessageFromPanel(@ModelAttribute MessageDto message)
    {
        generateMessage(message);
        return new RedirectView("/panel");
    }

    @PostMapping("/panel/delete")
    public RedirectView deleteMessageFromPanel(@RequestParam String messageId)
    {
        deleteMessage(messageId);
        return new RedirectView("/panel");
    }

    @PutMapping
    public ResponseEntity<String> generateMessage(@RequestBody MessageDto message)
    {
        var response = messageService.createMessage(message);
        return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);
    }

    @DeleteMapping("/{messageId}")
    public ResponseEntity<String> deleteMessage(@PathVariable String messageId)
    {
        var response = messageService.deleteMessage(messageId);
        return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);
    }

    @GetMapping("/{messageId}")
    public ResponseEntity<MessageDto> getMessage(@PathVariable String messageId)
            throws MessageNotFound
    {
        var response = messageService.getMessage(messageId);

        if (response instanceof FailedMessageDto)
        {
            throw new MessageNotFound(messageId);
        }

        return new ResponseEntity<MessageDto>((MessageDto)response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MessageDto>> getAllMessages()
    {
        var response = messageService.getAllMessages();

        return new ResponseEntity<List<MessageDto>>(response, HttpStatus.OK);
    }
}
