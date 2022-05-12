package com.HotelBooking.app.service;

import com.HotelBooking.app.model.BookingMember;
import com.HotelBooking.app.repository.BookingMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingMemberService {


	private final BookingMemberRepository bookingMemberRepository;

	public BookingMemberService(BookingMemberRepository bookingMemberRepository) {
		this.bookingMemberRepository = bookingMemberRepository;
	}


	public List<BookingMember> getAllBookingMembers(){
		return bookingMemberRepository.findAll();
	}

	public BookingMember getBookingMemberById(long id){
		Optional<BookingMember> bookingMember = bookingMemberRepository.findById(id);
		if(bookingMember.isPresent()){
			return bookingMember.get();
		}
		return null;
	}

	public void addBookingMember(BookingMember bookingMember){
		bookingMemberRepository.save(bookingMember);
	}

	public void updateBookingMember(BookingMember bookingMember){
		bookingMemberRepository.save(bookingMember);
	}

	public void deleteBookingMember(long id){
		bookingMemberRepository.deleteById(id);
	}

}





