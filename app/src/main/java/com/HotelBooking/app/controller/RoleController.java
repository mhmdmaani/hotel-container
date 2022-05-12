package com.HotelBooking.app.controller;

import com.HotelBooking.app.model.Role;
import com.HotelBooking.app.service.RoleService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/role")
public class RoleController {


    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {

        return new ResponseEntity<>(roleService.getRoleById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> add(@RequestBody Role role) {
        roleService.addRole(role);
        return new ResponseEntity<>("Role added", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Role role, @PathVariable long id) {
        roleService.updateRole(role);
        
        if(role.getName() != null) {
            role.setName(role.getName());
        }
        if(role.getDescription() != null) {
            role.setDescription(role.getDescription());
        }
        
        
        return new ResponseEntity<>("Role updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        roleService.deleteRole(id);
        return new ResponseEntity<>("Role deleted", HttpStatus.OK);
    }
    
    
}
