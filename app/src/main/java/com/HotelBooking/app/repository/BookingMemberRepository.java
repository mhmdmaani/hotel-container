package com.HotelBooking.app.repository;

import com.HotelBooking.app.model.BookingMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingMemberRepository extends JpaRepository<BookingMember, Long>{

}
