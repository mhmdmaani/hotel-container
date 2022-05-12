package com.HotelBooking.app.controller;

import com.HotelBooking.app.model.Customer;
import com.HotelBooking.app.service.CustomerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {

        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> add(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return new ResponseEntity<>("Customer added", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Customer customer, @PathVariable long id) {
        customerService.updateCustomer(customer);
        if (customer.getName() != null) {
            customer.setName(customer.getName());
        }
        if (customer.getAddress() != null) {
            customer.setAddress(customer.getAddress());
        }
        if (customer.getEmail() != null) {
            customer.setEmail(customer.getEmail());
        }
        if (customer.getTel() != null) {
            customer.setTel(customer.getTel());
        }

        if(customer.getImage() != null) {
            customer.setImage(customer.getImage());
        }
        
        
        customerService.updateCustomer(customer);
        return new ResponseEntity <>("Customer updated", HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
    }


}
