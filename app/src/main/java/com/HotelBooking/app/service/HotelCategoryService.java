package com.HotelBooking.app.service;

import com.HotelBooking.app.model.HotelCategory;
import com.HotelBooking.app.repository.HotelCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelCategoryService {


	private final HotelCategoryRepository hotelCategoryRepository;

	public HotelCategoryService(HotelCategoryRepository hotelCategoryRepository) {
		this.hotelCategoryRepository = hotelCategoryRepository;
	}

	public List<HotelCategory> getAllHotelCategories() {
		return hotelCategoryRepository.findAll();
	}

	public HotelCategory getHotelCategoryById(Long id) {
		Optional<HotelCategory> hotelCategory = hotelCategoryRepository.findById(id);
		if (hotelCategory.isPresent()) {
			return hotelCategory.get();
		}
		return null;
	}

	public void deleteHotelCategoryById(Long id) {
		hotelCategoryRepository.deleteById(id);
	}

	public HotelCategory addHotelCategory(HotelCategory hotelCategory) {
		return hotelCategoryRepository.save(hotelCategory);
	}

	public HotelCategory updateHotelCategory(HotelCategory hotelCategory) {
		return hotelCategoryRepository.save(hotelCategory);
	}

    public void deleteHotelCategory(long id) { hotelCategoryRepository.deleteById(id); }

}