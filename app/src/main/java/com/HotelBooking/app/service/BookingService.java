package com.HotelBooking.app.service;

import com.HotelBooking.app.model.Booking;
import com.HotelBooking.app.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {


	private final BookingRepository bookingRepository;

	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	public Booking getBookingById(Long id) {
		Optional<Booking> booking = bookingRepository.findById(id);
		if(booking.isPresent()) {
			return booking.get();
		}
		return null;
	}

	public Booking addBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	public void updateBooking(Booking booking) {
		bookingRepository.save(booking);
	}
	public void deleteBooking(Long id) {
		bookingRepository.deleteById(id);
	}
}



