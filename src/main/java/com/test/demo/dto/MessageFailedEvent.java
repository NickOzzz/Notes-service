package com.test.demo.dto;

public class MessageFailedEvent implements IMessageEvent {
    private final String messageId;
    private final Operations operation;

    public MessageFailedEvent(String messageId, Operations operation)
    {
        this.messageId = messageId;
        this.operation = operation;
    }

    public String getMessage()
    {
        return "Failed to " + this.operation.toString() +" message with Id" + this.messageId;
    }
}
