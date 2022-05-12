package com.HotelBooking.app.sender;

import com.HotelBooking.app.config.JmsConfig;
import com.HotelBooking.app.exception.GlobalExceptionHandler;
import com.HotelBooking.app.model.MessageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class Sender {

    private final JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }



    public  void sendMessage(String message) {

        System.out.println("Sending message...");
        try{
            MessageObject messageObject =
                    new MessageObject(UUID.randomUUID(), message, LocalDateTime.now());
            jmsTemplate.convertAndSend(JmsConfig.HOTEL_APP_QUEUE, messageObject);

            System.out.println("Message sent!");
        }catch (Exception e){
                        System.out.println("Message not sent!");
        }


    }
}
