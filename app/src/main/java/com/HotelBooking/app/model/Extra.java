package com.HotelBooking.app.model;


import javax.persistence.*;
import java.util.List;


@Entity
public class Extra {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private double price;
    private String description;
    private double cost_price;
    private String image;
    private boolean is_active;

    @ManyToOne
    private Hotel hotel;

    @ManyToMany
    private List<Booking> bookings;

    public Extra() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCostPrice() {
        return cost_price;
    }

    public void setCostPrice(double cost_price) {
        this.cost_price = cost_price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public boolean setIsActive() {
        return is_active;
    }

    public void getIsActive(boolean is_active) {
        this.is_active = is_active;
    }

    

    
    
}
