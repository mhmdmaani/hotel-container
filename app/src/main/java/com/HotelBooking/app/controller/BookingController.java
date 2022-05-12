package com.HotelBooking.app.controller;



import com.HotelBooking.app.model.Booking;
import com.HotelBooking.app.service.BookingService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/booking")
public class BookingController {
 

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {
        Booking found = bookingService.getBookingById(id);
        if (found == null) {
            return new ResponseEntity<>("Booking not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> add(@RequestBody Booking booking) {
        bookingService.addBooking(booking);
        return new ResponseEntity<>("Booking added", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Booking booking, @PathVariable long id) {
        Booking updatedBooking = bookingService.getBookingById(id);

        if (booking.getCheckInDate() != null) {
            updatedBooking.setCheckInDate(booking.getCheckInDate());
        }
        if (booking.getCheckoutDate() != null) {
            updatedBooking.setCheckoutDate(booking.getCheckoutDate());
        }
        if (booking.getRoomId() != 0) {
            updatedBooking.setRoomId(booking.getRoomId());
        }
        
        bookingService.updateBooking(updatedBooking);
        return new ResponseEntity<>("Booking updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        Booking booking = bookingService.getBookingById(id);
        if (booking == null) {
            return new ResponseEntity<>("Booking not found", HttpStatus.NOT_FOUND);
        }
        bookingService.deleteBooking(id);
        return new ResponseEntity<>("Booking deleted", HttpStatus.OK);
    }
    
    
}