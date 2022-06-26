package com.tpe.repository;


import org.springframework.stereotype.Component;

@Component("fileMessageRepository")
public class FileMessageRepository implements MessageRepository {
    @Override
    public void saveMessage(String message) {
        System.out.println("I am saving in the message in File:"+message);
    }
}
