package com.test.demo.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "message_details")
public class MessageDto implements IDto {

    @NotBlank(message="Note cannot be empty or contain whitespaces")
    @NotEmpty(message="Note cannot be empty or contain whitespaces")
    @Column(name = "message")
    private String message;

    @Column(name="create_time")
    private String timeOfCreation;

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

    public void setTime(String time)
    {
        timeOfCreation = time;
    }

    public String getMessage()
    {
           return this.message;
    }

    public Integer getMessageId()
    {
        return this.messageId;
    }

    public String getTimeOfCreation()
    {
        return this.timeOfCreation;
    }
}
