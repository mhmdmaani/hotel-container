package com.HotelBooking.app.controller;

import java.util.List;

import com.HotelBooking.app.model.Hotel;
import com.HotelBooking.app.service.HotelService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/hotels")
public class HotelController {


	private final HotelService hotelService;

	public HotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}


	// display list of Hotels
	@GetMapping("")
	@ApiOperation("Get all hotels")
	public ResponseEntity<Object> getAll() {
		return new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getById( @PathVariable long id) {
		Hotel found = hotelService.getHotelById(id);
		if(found == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(found, HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<Object> create(@RequestBody Hotel hotel) {
	 Hotel saved =  hotelService.saveHotel(hotel);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Hotel hotel, @PathVariable long id) {
		Hotel updatedHotel = hotelService.getHotelById(id);
		if(hotel.getAddress() != null) {
			updatedHotel.setAddress(hotel.getAddress());
		}

		if(hotel.getName() != null) {
			updatedHotel.setName(hotel.getName());
		}
		if (hotel.getTel() != null) {
			updatedHotel.setTel(hotel.getTel());
		}
		if (hotel.getEmail() != null) {
			updatedHotel.setEmail(hotel.getEmail());
		}
		if (hotel.getWebsite() != null) {
			updatedHotel.setWebsite(hotel.getWebsite());
		}
		if (hotel.getLat() != 0.0) {
			updatedHotel.setLat(hotel.getLat());
		}
		if(hotel.getLng() != 0.0) {
			updatedHotel.setLng(hotel.getLng());
		}
		if (hotel.getImage() != null) {
			updatedHotel.setImage(hotel.getImage());
		}
		Hotel saved  = hotelService.saveHotel(updatedHotel);
		return new ResponseEntity<>(saved, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		hotelService.deleteHotelById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<Object> search(@RequestParam(value = "name") String name){
		List<Hotel> hotels = hotelService.findByKeyword(name);
		return new ResponseEntity<>(hotels, HttpStatus.OK);
	}

}
