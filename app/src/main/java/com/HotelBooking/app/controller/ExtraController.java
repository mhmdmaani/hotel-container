package com.HotelBooking.app.controller;

import com.HotelBooking.app.model.Extra;
import com.HotelBooking.app.service.ExtraService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RequestMapping("/api/extra")
public class ExtraController {


    private final ExtraService extraService;

    public ExtraController(ExtraService extraService) {
        this.extraService = extraService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(extraService.getAllExtras(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {
        Extra found = extraService.getExtraByid(id);
        if (found == null) {
            return new ResponseEntity<>("Extra not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> add(@RequestBody Extra extra) {
        extraService.addExtra(extra);
        return new ResponseEntity<>("Extra added", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Extra extra, @PathVariable long id) {
        Extra found = extraService.getExtraByid(id);
        if (found == null) {
            return new ResponseEntity<>("Extra not found", HttpStatus.NOT_FOUND);
        }
        if (extra.getName() != null) {
            found.setName(extra.getName());
        }
        if (extra.getDescription() != null) {
            found.setDescription(extra.getDescription());
        }
        if (extra.getPrice() != 0) {
            found.setPrice(extra.getPrice());
        }
        if (extra.getImage() != null) {
            found.setImage(extra.getImage());
        }
        extraService.updateExtra(found);
        return new ResponseEntity<>("Extra updated", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        Extra found = extraService.getExtraByid(id);
        if (found == null) {
            return new ResponseEntity<>("Extra not found", HttpStatus.NOT_FOUND);
        }
        extraService.deleteExtra(id);
        return new ResponseEntity<>("Extra deleted", HttpStatus.OK);
    }
}
