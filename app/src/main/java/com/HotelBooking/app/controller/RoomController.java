package com.HotelBooking.app.controller;

import com.HotelBooking.app.model.Booking;
import com.HotelBooking.app.model.Room;
import com.HotelBooking.app.service.BookingService;
import com.HotelBooking.app.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private  RoomService roomService;

    @Autowired
    private BookingService bookingService;

    public RoomController(RoomService roomService ,BookingService bookingService) {
        this.roomService = roomService;
        this.bookingService = bookingService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model, String keyword) {

        return findPaginated(1, "name", "asc", model, keyword);
    }

    @GetMapping
    String getRooms(Model model) {
        model.addAttribute("whatever", "this is a test");
        return "rooms";
    }

    @GetMapping("/showNewRoomForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Room room = new Room();
        model.addAttribute("room", room);
        return "new_room";
    }

    @PostMapping("/saveRoom")
    public String saveRoom(@ModelAttribute("room") Room room) {
        // save Room to database
        roomService.addRoom(room);
        return "redirect:/";
    }

    @PostMapping("/bookRoom")
    public String bookRoom(@ModelAttribute("booking") Booking booking) {
        // save Room to database
        bookingService.addBooking(booking);
        return "home";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get Room from the service
        Room room = roomService.getRoomById(id);

        // set Room as a model attribute to pre-populate the form
        model.addAttribute("room", room);
        return "update_room";
    }

    @GetMapping("/deleteRoom/{id}")
    public String deleteRoom(@PathVariable(value = "id") long id) {

        // call delete Room method
        this.roomService.deleteRoom(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model, String keyword) {
        int pageSize = 5;

        Page<Room> page = roomService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Room> listRooms;

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        if (keyword != null) {

            listRooms = roomService.findByKeyword(keyword);
        } else {

            listRooms = page.getContent();
        }
        model.addAttribute("listRooms", listRooms);

        return "index";
    }

    @GetMapping("/ShowHome")
    public String test( Model model, String keyword) {
        List<Room> Rooms;

        if (keyword != null) {

            Rooms= roomService.findByKeyword(keyword);
        } else {

            Rooms = roomService.getAllRooms();
        }
        model.addAttribute("Rooms", Rooms);

        return "home";
    }
}
