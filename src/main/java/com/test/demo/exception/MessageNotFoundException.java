package com.test.demo.exception;

public class MessageNotFoundException extends Throwable {
    private String Error;

    public MessageNotFoundException(String Error)
    {
        this.Error = Error;
    }

    public String getError()
    {
        return this.Error;
    }
}
