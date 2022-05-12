package com.HotelBooking.app.repository;

import com.HotelBooking.app.model.Booking;
import com.HotelBooking.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
