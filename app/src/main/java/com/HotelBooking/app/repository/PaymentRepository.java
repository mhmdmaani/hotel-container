package com.HotelBooking.app.repository;

import com.HotelBooking.app.model.Customer;
import com.HotelBooking.app.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
