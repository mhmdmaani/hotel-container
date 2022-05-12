package com.HotelBooking.app.repository;

import com.HotelBooking.app.model.Booking;
import com.HotelBooking.app.model.HotelCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
