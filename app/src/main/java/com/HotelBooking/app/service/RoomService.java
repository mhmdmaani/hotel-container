package com.HotelBooking.app.service;

import com.HotelBooking.app.model.Room;
import com.HotelBooking.app.repository.RoomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {


	private final RoomRepository roomRepository;

	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

	public Room getRoomById(Long id) {
		Optional<Room> room = roomRepository.findById(id);
		if(room.isPresent()) {
			return room.get();
		}
		return null;
	}

	public Room addRoom(Room room) {
		return roomRepository.save(room);
	}

	public void updateRoom(Room room) {
		roomRepository.save(room);
	}
	public void deleteRoom(Long id) {
		roomRepository.deleteById(id);
	}

	public Page<Room> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
				Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.roomRepository.findAll(pageable);
	}

	public List<Room> findByKeyword(String keyword) {
		return roomRepository.findByKeyword(keyword);
	}
}



