package com.HotelBooking.app.repository;

import com.HotelBooking.app.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
     @Query(value="select * from Hotel p where p.name like %:keyword% ",nativeQuery = true)
     List<Hotel> findByKeyword(@Param("keyword")String keyword);
}
