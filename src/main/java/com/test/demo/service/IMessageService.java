package com.test.demo.service;

import com.test.demo.dto.IDto;
import com.test.demo.dto.IMessageEvent;
import com.test.demo.dto.MessageDto;

import java.util.List;

public interface IMessageService {
    IMessageEvent createMessage(MessageDto message);
    IDto getMessage(String messageId);
    IMessageEvent deleteMessage(String messageId);
    List<MessageDto> getAllMessages();
}
