package com.HotelBooking.app.repository;

import com.HotelBooking.app.model.Role;
import com.HotelBooking.app.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
    @Query(value="select * from Room p where p.name like %:keyword% or p.description like %:keyword% ",nativeQuery = true)
    List<Room> findByKeyword(@Param("keyword")String keyword);
}
