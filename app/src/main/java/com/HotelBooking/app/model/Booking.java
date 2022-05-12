package com.HotelBooking.app.model;


import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.util.List;


@Entity

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long Customer_id;
    private String checkin_date;
    private String checkout_date;

    private long room_id;
    private String description;

    @OneToMany
    private List<BookingMember> bookingMembers;

    @ManyToOne
    private Customer customers;

    @ManyToOne
    private Room rooms;

    @ManyToMany
    private List<Extra> extras;


    public Booking() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return Customer_id;
    }

    public void setCustomerId(long customer_id) {
        Customer_id = customer_id;
    }


    public String getCheckInDate() {
        return checkin_date;
    }

    public void setCheckInDate(String check_in) {
        this.checkin_date = check_in;
    }

    public String getCheckoutDate() {
        return checkout_date;
    }

    public void setCheckoutDate(String check_out) {
        this.checkout_date = check_out;
    }

    public long getRoomId() {
        return room_id;
    }

    public void setRoomId(long room_id) {
        this.room_id = room_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
