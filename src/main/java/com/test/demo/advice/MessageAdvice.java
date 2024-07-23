package com.test.demo.advice;

import com.test.demo.exception.MessageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MessageAdvice {
    @ExceptionHandler
    public ResponseEntity<String> generateMessageNotFoundStatusCode(MessageNotFoundException message)
    {
        return new ResponseEntity<String>(message.getError(), HttpStatus.NOT_FOUND);
    }
}
