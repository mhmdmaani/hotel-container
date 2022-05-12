package com.HotelBooking.app.controller;

import com.HotelBooking.app.model.Room;
import com.HotelBooking.app.service.RoomService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/room")
public class RoomApiController {


    private final RoomService roomService;

    public RoomApiController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(roomService.getAllRooms(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {

        return new ResponseEntity<>(roomService.getRoomById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> add(@RequestBody Room room) {
        roomService.addRoom(room);
        return new ResponseEntity<>("Room added", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Room room, @PathVariable long id) {
        roomService.updateRoom(room);
        
        if(room.getName() != null) {
            room.setName(room.getName());
        }
        if(room.getDescription() != null) {
            room.setDescription(room.getDescription());
        }
        if(room.getPrice() != 0) {
            room.setPrice(room.getPrice());
        }
       
        
        return new ResponseEntity<>("Room updated", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        roomService.deleteRoom(id);
        return new ResponseEntity<>("Room deleted", HttpStatus.OK);
    }
    
}
