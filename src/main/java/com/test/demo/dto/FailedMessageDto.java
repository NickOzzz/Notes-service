package com.test.demo.dto;

public class FailedMessageDto implements IDto {
    private final String ErrorMessage;

    public FailedMessageDto(String ErrorMessage)
    {
        this.ErrorMessage = ErrorMessage;
    }

    public String GetErrorMessage()
    {
        return ErrorMessage;
    }
}
