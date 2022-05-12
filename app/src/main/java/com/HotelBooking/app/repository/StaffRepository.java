package com.HotelBooking.app.repository;

import com.HotelBooking.app.model.Role;
import com.HotelBooking.app.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>{
    @Query(
            value = "SELECT * FROM staff u WHERE u.username = ?1",
            nativeQuery = true)
    Staff findByUsername(String username);

}
