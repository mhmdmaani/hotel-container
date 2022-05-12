package com.HotelBooking.app.repository;

import com.HotelBooking.app.model.Hotel;
import com.HotelBooking.app.model.HotelCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelCategoryRepository extends JpaRepository<HotelCategory, Long>{

}
