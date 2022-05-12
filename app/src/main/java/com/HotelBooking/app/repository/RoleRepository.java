package com.HotelBooking.app.repository;

import com.HotelBooking.app.model.Payment;
import com.HotelBooking.app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
}
