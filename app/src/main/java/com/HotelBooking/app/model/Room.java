package com.HotelBooking.app.model;


import javax.persistence.*;
import java.util.List;


@Entity

public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    private boolean is_occupied;


    @ManyToOne
    private Hotel hotel;


    @ManyToOne
    private RoomType roomType;

    @OneToMany
    private List<Booking> bookings;




    public Room() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getIsOccupied() {
        return is_occupied;
    }

    public void setIsOccupied(boolean is_occupied) {
        this.is_occupied = is_occupied;
    }


}
