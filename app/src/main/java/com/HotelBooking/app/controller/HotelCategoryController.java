package com.HotelBooking.app.controller;

import com.HotelBooking.app.model.HotelCategory;
import com.HotelBooking.app.service.HotelCategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RequestMapping("/api/hotelCategory")
public class HotelCategoryController {


    private final HotelCategoryService hotelCategoryService;

    public HotelCategoryController(HotelCategoryService hotelCategoryService) {
        this.hotelCategoryService = hotelCategoryService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(hotelCategoryService.getAllHotelCategories(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {
        return new ResponseEntity<>(hotelCategoryService.getHotelCategoryById(id), HttpStatus.OK);
    }
    
    @PostMapping("")
    public ResponseEntity<Object> add(@RequestBody HotelCategory hotelCategory) {
        hotelCategoryService.addHotelCategory(hotelCategory);
        return new ResponseEntity<>("Hotel Category added", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody HotelCategory hotelCategory, @PathVariable long id) {
        HotelCategory found = hotelCategoryService.getHotelCategoryById(id);
        if (found == null) {
            return new ResponseEntity<>("Hotel Category not found", HttpStatus.NOT_FOUND);
        }
        if (hotelCategory.getName() != null) {
            found.setName(hotelCategory.getName());
        }
        if (hotelCategory.getDescription() != null) {
            found.setDescription(hotelCategory.getDescription());
        }
       
        return new ResponseEntity<>("Hotel Category updated", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        HotelCategory found = hotelCategoryService.getHotelCategoryById(id);
        if (found == null) {
            return new ResponseEntity<>("Hotel Category not found", HttpStatus.NOT_FOUND);
        }
        hotelCategoryService.deleteHotelCategory(id);
        return new ResponseEntity<>("Hotel Category deleted", HttpStatus.OK);
    }


}
