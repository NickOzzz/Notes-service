package com.test.demo.service;

import com.test.demo.dto.IDto;
import com.test.demo.event.IMessageEvent;
import com.test.demo.dto.MessageDto;
import com.test.demo.exception.MessageNotFoundException;

import java.util.List;

public interface IMessageService {
    IMessageEvent createMessage(MessageDto message);
    IMessageEvent updateMessage(MessageDto message);
    IDto getMessage(String messageId) throws MessageNotFoundException;
    IMessageEvent deleteMessage(String messageId);
    List<MessageDto> getAllMessages();
}
