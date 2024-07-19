package com.test.demo.dto;

public class MessageNotFound extends Throwable {
    public String Error;

    public MessageNotFound(String Error)
    {
        this.Error = Error;
    }
}
