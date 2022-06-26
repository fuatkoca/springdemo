package com.tpe.service;

import com.tpe.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("whatsAppService")
public class WhatsAppService implements  MessageService{

    //We can inject  more beans into another bean. In this class we inject two MessageRepositories.
    //One of them is DbMessageRepository, another one is FileMessageRepository
    private MessageRepository messageRepository;
    private MessageRepository fileMessageRepository;

    @Autowired
    public WhatsAppService (@Qualifier("dbMessageRepository") MessageRepository messageRepository,
                            @Qualifier("fileMessageRepository") MessageRepository fileMessageRepository
                            ){
        this.messageRepository=messageRepository;
        this.fileMessageRepository=fileMessageRepository;
    }

    @Override
    public String sendMessage() {
        messageRepository.saveMessage("Hello from WhatsAppService");

        fileMessageRepository.saveMessage("Hello from WhatsAppService");
        return "I am the WhatsApp Service";
    }
}
