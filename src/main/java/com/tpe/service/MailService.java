package com.tpe.service;


import com.tpe.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mailService")
public class MailService implements MessageService {

    //@Autowired //In order to inject a bean into another Bean, you have to use @Autowired annotation
    //When you run the application, Spring Container scans  classes that has @Component annotation then find the then create a Bean fronm the class then
    //then put the bean into Spring Container. When any Bean needs another bean inject into Bean with the @Autowired annotation.

    //@Qualifier("fileMessageRepository")
    //In order to select specific bean for injection, You have to use @Qualifier annotation wit the name

    /*Field Injection
    @Autowired
    @Qualifier("fileMessageRepository")
    private MessageRepository messageRepository;
    */


    /*Constructor Injection It is recommended to use Constructor Injection
    private MessageRepository messageRepository;

    @Autowired
    public MailService(@Qualifier("fileMessageRepository") MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }
    */

    @Value("${app.email}")
    private String email;

    @Value("${app.count}")
    private Integer count;

    private MessageRepository messageRepository;

    //It is the setter injection
    @Autowired
    @Qualifier("fileMessageRepository")
    public void setMessageRepository(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }


    @Override
    public String sendMessage() {
        messageRepository.saveMessage("Hello");
        return "I am the Mail Service, I sent a message:"+email+":"+count;
    }
}
