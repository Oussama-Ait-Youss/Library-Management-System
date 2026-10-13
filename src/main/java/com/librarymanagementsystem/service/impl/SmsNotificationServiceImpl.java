package com.librarymanagementsystem.service.impl;

import com.librarymanagementsystem.service.NotificationService;

public class SmsNotificationServiceImpl implements NotificationService {


    @Override
    public void SendNotification(String message){
        System.out.println("Sms message : " + message);
    }
}
