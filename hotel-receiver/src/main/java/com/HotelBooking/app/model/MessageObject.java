package com.HotelBooking.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public class MessageObject {

    private UUID id;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm:ss")
    private LocalDateTime localDatetime;

    public MessageObject(UUID id, String message, LocalDateTime localDatetime) {
        this.id = id;
        this.message = message;
        this.localDatetime = localDatetime;
    }

    public MessageObject() {}

    public UUID getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDatetime() {
        return localDatetime;
    }

    @Override
    public String toString() {
        return "MessageObject{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", localDatetime=" + localDatetime +
                '}';
    }
}
