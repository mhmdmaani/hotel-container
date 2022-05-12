package com.HotelBooking.app.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.HotelBooking.app.config.JmsConfig;
import com.HotelBooking.app.model.MessageObject;

@Component
public class Receiver {

    @JmsListener(destination = JmsConfig.HOTEL_APP_QUEUE)
    public void listen(@Payload MessageObject messageObject) {
        System.out.println("I got a message");
        System.out.println(messageObject);
    }

}
