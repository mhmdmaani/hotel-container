package com.HotelBooking.app.exception;


import com.HotelBooking.app.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomException extends Exception {

    @Autowired
    private Sender sender;
        public CustomException(String message) {
            super(message);
            ;
        }
    }
