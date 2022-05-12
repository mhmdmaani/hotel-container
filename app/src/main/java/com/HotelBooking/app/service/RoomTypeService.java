package com.HotelBooking.app.service;

import java.util.List;
import java.util.Optional;

import com.HotelBooking.app.model.RoomType;
import com.HotelBooking.app.repository.RoomTypeRepository;

import org.springframework.stereotype.Service;

@Service
public class RoomTypeService {


    private final  RoomTypeRepository roomTypeRepository;

    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    public List<RoomType> getAllRoomTypes(){
        return roomTypeRepository.findAll();
    }

    public RoomType getRoomTypeById(long id){
        Optional<RoomType> roomType = roomTypeRepository.findById(id);
        if(roomType.isPresent()){
            return roomType.get();
        }
        return null;
    }

    public void addRoomType(RoomType roomType){
        roomTypeRepository.save(roomType);
    }

    public void updateRoomType(RoomType roomType){
        roomTypeRepository.save(roomType);
    }

    public void deleteRoomType(long id){
        roomTypeRepository.deleteById(id);
    }
    
}
