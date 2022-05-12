package com.HotelBooking.app.controller;

import com.HotelBooking.app.model.RoomType;
import com.HotelBooking.app.service.RoomTypeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/roomtype")
public class RoomTypeController {


    private final RoomTypeService roomTypeService;

    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(roomTypeService.getAllRoomTypes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {

        return new ResponseEntity<>(roomTypeService.getRoomTypeById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> add(@RequestBody RoomType roomType) {
        roomTypeService.addRoomType(roomType);
        return new ResponseEntity<>("RoomType added", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody RoomType roomType, @PathVariable long id) {
        roomTypeService.updateRoomType(roomType);

        if(roomType.getName() != null) {
            roomType.setName(roomType.getName());
        }
        if(roomType.getDescription() != null) {
            roomType.setDescription(roomType.getDescription());
        }
       

        return new ResponseEntity<>("RoomType updated", HttpStatus.OK);
    }@DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        roomTypeService.deleteRoomType(id);
        return new ResponseEntity<>("RoomType deleted", HttpStatus.OK);
    }
    
    
}
