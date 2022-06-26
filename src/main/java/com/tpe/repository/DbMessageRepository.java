package com.tpe.repository;

import org.springframework.stereotype.Component;

@Component("dbMessageRepository")
public class DbMessageRepository implements MessageRepository {
    @Override
    public void saveMessage(String message) {
        System.out.println("I am saving the message in DB:"+message);
    }
}
