package com.HotelBooking.app.service;

import java.util.List;
import java.util.Optional;

import com.HotelBooking.app.model.Hotel;
import com.HotelBooking.app.repository.HotelRepository;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

@Service
public class HotelService {


	private final HotelRepository hotelRepository;

	public HotelService(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}


	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	public Hotel saveHotel(Hotel hotel) {
		Hotel savedHotel = this.hotelRepository.save(hotel);
		return savedHotel ;
	}

	public Hotel getHotelById(long id) {
		Optional<Hotel> optional = hotelRepository.findById(id);
		Hotel hotel = null;
		if (optional.isPresent()) {
			hotel = optional.get();
		} else {
			throw new RuntimeException(" Hotel not found for id :: " + id);
		}
		return hotel;
	}

	public void deleteHotelById(long id) {
		this.hotelRepository.deleteById(id);
	}

	public Page<Hotel> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
				Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.hotelRepository.findAll(pageable);
	}

	public List<Hotel> findByKeyword(String keyword) {
		return hotelRepository.findByKeyword(keyword);
	}
}
