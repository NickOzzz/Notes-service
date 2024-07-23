package com.test.demo.event;

import com.test.demo.dto.Operations;

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
