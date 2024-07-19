package com.test.demo.service;

import com.test.demo.dto.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MessageService implements IMessageService {

    private final EntityManager sqlExecutor;

    @Autowired
    public MessageService(EntityManager sqlExecutor)
    {
        this.sqlExecutor = sqlExecutor;
    }

    @Override
    @Transactional
    public IMessageEvent createMessage(MessageDto message)
    {
       try
       {
           sqlExecutor.persist(message);
           return new MessageCreatedEvent(message.getMessageId().toString());
       }
       catch(Exception ex)
       {
           return new MessageFailedEvent(message.getMessageId().toString(), Operations.Create);
       }
    }

    @Override
    @Transactional
    public IDto getMessage(String messageId)
    {
        var message = sqlExecutor.find(MessageDto.class, messageId);

        if (message == null)
        {
            return new FailedMessageDto("Could not retrieve message by Id " + messageId);
        }
        return message;
    }

    @Override
    @Transactional
    public IMessageEvent deleteMessage(String messageId)
    {
        var message = sqlExecutor.find(MessageDto.class, messageId);
        if (message == null)
        {
            return new MessageFailedEvent(messageId, Operations.Delete);
        }

        this.sqlExecutor.remove(message);
        return new MessageDeletedEvent(messageId);
    }

    @Override
    @Transactional
    public List<MessageDto> getAllMessages()
    {
        var query = sqlExecutor.createQuery("FROM MessageDto");
        return query.getResultList();
    }
}
