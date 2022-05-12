package com.HotelBooking.app.controller;


import com.HotelBooking.app.exception.CustomException;
import com.HotelBooking.app.model.Hotel;
import com.HotelBooking.app.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/hotels")
public class IndexController {
    @GetMapping
    public String homePage() throws CustomException {

        throw new CustomException("NAAAAAEJ");
    }
    private final HotelService hotelService;

    public IndexController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Model model) {
        List<Hotel> hotels = hotelService.getAllHotels();
        model.addAttribute("hotels", hotels);
        return "index";
    }
}

