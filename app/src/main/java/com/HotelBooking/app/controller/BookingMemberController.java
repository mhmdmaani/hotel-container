package com.HotelBooking.app.controller;

import com.HotelBooking.app.model.BookingMember;
import com.HotelBooking.app.service.BookingMemberService;

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
@RequestMapping("/api/bookingmembers")
public class BookingMemberController {


    private final BookingMemberService bookingMemberService;

    public BookingMemberController(BookingMemberService bookingMemberService) {
        this.bookingMemberService = bookingMemberService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(bookingMemberService.getAllBookingMembers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {
       
        return new ResponseEntity<>(bookingMemberService.getBookingMemberById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> add(@RequestBody BookingMember bookingMember) {
        bookingMemberService.addBookingMember(bookingMember);
        return new ResponseEntity<>("Booking Member added", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody BookingMember bookingMember, @PathVariable long id) {
        bookingMemberService.updateBookingMember(bookingMember);
        if (bookingMember.getName() != null) {
            bookingMember.setName(bookingMember.getName());
        }
        if (bookingMember.getEmail() != null) {
            bookingMember.setEmail(bookingMember.getEmail());
        }
        if (bookingMember.getTel() != null) {
            bookingMember.setTel(bookingMember.getTel());
        }
        if (bookingMember.getAddress() != null) {
            bookingMember.setAddress(bookingMember.getAddress());
        }
        if (bookingMember.getImage() != null) {
            bookingMember.setImage(bookingMember.getImage());
        }
        if (bookingMember.getDocumentId() != null) {
            bookingMember.setDocumentId(bookingMember.getDocumentId());
        }

        bookingMemberService.updateBookingMember(bookingMember);
        return new ResponseEntity<>("Booking Member updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        bookingMemberService.deleteBookingMember(id);
        return new ResponseEntity<>("Booking Member deleted", HttpStatus.OK);
    }






}
