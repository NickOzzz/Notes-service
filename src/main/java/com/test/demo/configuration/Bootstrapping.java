package com.test.demo.configuration;

import com.test.demo.service.IMessageService;
import com.test.demo.service.MessageService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Bootstrapping {
    @Bean
    public IMessageService createMessageService(EntityManager sqlExecutor)
    {
        return new MessageService(sqlExecutor);
    }
}
