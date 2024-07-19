package com.test.demo.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "message_details")
public class MessageDto implements IDto {

    @Column(name = "message")
    private String message;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer messageId;

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setMessageId(Integer messageId)
    {
        this.messageId = messageId;
    }

    public String getMessage()
    {
           return this.message;
    }

    public Integer getMessageId()
    {
        return this.messageId;
    }
}
