package com.librarymanagementsystem.service.impl;


import com.librarymanagementsystem.service.NotificationService;
import org.springframework.stereotype.Component;


@Component
public class EmailNotificationServiceImpl implements NotificationService {

    @Override
    public void SendNotification(String message){
        System.out.println("Email message : " + message);
    }
}
