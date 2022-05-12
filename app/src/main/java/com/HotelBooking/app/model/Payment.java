package com.HotelBooking.app.model;


import javax.persistence.*;
import java.util.Date;


@Entity

public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long Customer_id;
    private long Hotel_id;
    private Date payment_date;
    private String payment_method;
    private String reference_id;

    @ManyToOne
    private Customer customers;

    @ManyToOne
    private Hotel hotels;
    
    public Payment() {
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

    public long getHotelId() {
        return Hotel_id;
    }

    public void setHotelId(long hotel_id) {
        Hotel_id = hotel_id;
    }

    public Date getPaymentDate() {
        return payment_date;
    }

    public void setPaymentDate(Date payment_date) {
        this.payment_date = payment_date;
    }

    public String getPaymentMethod() {
        return payment_method;
    }

    public void setPaymentMethod(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getReferenceId() {
        return reference_id;
    }

    public void setReferenceId(String reference_id) {
        this.reference_id = reference_id;
    }

}
