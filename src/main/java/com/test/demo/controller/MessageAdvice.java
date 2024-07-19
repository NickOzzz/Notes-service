package com.test.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.test.demo.dto.*;

@ControllerAdvice
public class MessageAdvice {
    @ExceptionHandler
    public ResponseEntity<String> generateMessageNotFoundStatusCode(MessageNotFound message)
    {
        var errorMessage = "Message with id " + message.Error + " has not been found";
        return new ResponseEntity<String>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
