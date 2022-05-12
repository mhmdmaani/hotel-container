package com.HotelBooking.app.model;


import javax.persistence.*;
import java.util.List;


@Entity

public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String tel;
    private String address;
    private String image;
    private long document_id;
    private String document_type;

     @OneToMany
     private List<Booking> bookings;

     @OneToMany
     private List<Payment> payments;

    public Customer() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getDocumentId() {
        return document_id;
    }

    public void setDocumentId(long document_id) {
        this.document_id = document_id;
    }

    public String getDocumentType() {
        return document_type;
    }

    public void setDocumentType(String document_type) {
        this.document_type = document_type;
    }

    
    


}
