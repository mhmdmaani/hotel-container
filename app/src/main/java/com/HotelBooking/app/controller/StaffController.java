package com.HotelBooking.app.controller;


import com.HotelBooking.app.exception.CustomException;
import com.HotelBooking.app.exception.GlobalExceptionHandler;
import com.HotelBooking.app.model.Staff;
import com.HotelBooking.app.sender.Sender;
import com.HotelBooking.app.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    Sender sender;


    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() throws CustomException {
       List<Staff> foundStaff = staffService.getAllStaffs();

       if (foundStaff.isEmpty()) {

           CustomException customException = new CustomException("No staff found while getting all staff");
           sender.sendMessage(customException.getMessage());
           throw customException;
       }
        return new ResponseEntity<>(staffService.getAllStaffs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) throws CustomException {
        Staff foundStaff = staffService.getStaffById(id);

        if (foundStaff == null) {

            CustomException customException = new CustomException("No staff found while getting staff by id");
            sender.sendMessage(customException.getMessage());
            throw customException;

        }

        return new ResponseEntity<>(staffService.getStaffById(id), HttpStatus.OK);
    }

    @PostMapping("signup")
    public ResponseEntity<Staff> add(@RequestBody Staff staff) {

       Staff createdStaff = staffService.addStaff(staff);

        return new ResponseEntity<>(createdStaff, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Staff staff, @PathVariable long id) throws CustomException {

        Staff dbStaff = staffService.getStaffById(id);
        if(dbStaff == null) {
            CustomException ex =  new CustomException("staff with provided id is not existed");
            sender.sendMessage(ex.getMessage());
            throw ex;
        }
        if (staff.getName() == null) {
            staff.setName(dbStaff.getName());
        }
        if (staff.getUsername() == null) {
            staff.setUsername(dbStaff.getUsername());
        }
        if (staff.getAddress() == null) {
            staff.setAddress(dbStaff.getAddress());
        }
        if (staff.getEmail() == null) {
            staff.setEmail(dbStaff.getEmail());
        }
        if (staff.getTel() == null) {
            staff.setTel(dbStaff.getTel());
        }
        if (staff.getPassword() == null) {
            staff.setPassword(dbStaff.getPassword());
        }
        if (staff.getImage() == null) {
            staff.setImage(dbStaff.getImage());
        }
        if (staff.getRoles() == null) {
            staff.setRoles(dbStaff.getRoles());
        }
        if (staff.getDocumentId() == 0) {
            staff.setDocumentId(dbStaff.getDocumentId());
        }
        if (staff.getDocumentType() == null) {
            staff.setDocumentType(dbStaff.getDocumentType());
        }
        Staff updateStaff = staffService.updateStaff(staff);

        return new ResponseEntity<>(updateStaff, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) throws CustomException {

        Staff dbStaff = staffService.getStaffById(id);
        if(dbStaff == null) {
            CustomException ex = new CustomException("staff with provided id is not existed");
            sender.sendMessage(ex.getMessage());
            throw ex;
        }
        staffService.deleteStaff(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
