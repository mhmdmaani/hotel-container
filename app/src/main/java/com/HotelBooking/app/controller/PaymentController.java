package com.HotelBooking.app.controller;

import com.HotelBooking.app.model.Payment;
import com.HotelBooking.app.service.PaymentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/payment")
public class PaymentController {


    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(paymentService.getAllPayments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {

        return new ResponseEntity<>(paymentService.getPaymentById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> add(@RequestBody Payment payment) {
        paymentService.addPayment(payment);
        return new ResponseEntity<>("Payment added", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Payment payment, @PathVariable long id) {
        paymentService.updatePayment(payment);
        
        if(payment.getPaymentMethod() != null) {
            payment.setPaymentMethod(payment.getPaymentMethod());
        }
        if(payment.getPaymentMethod() != null) {
            payment.setPaymentMethod(payment.getPaymentMethod());
        }
        if(payment.getPaymentMethod() != null) {
            payment.setPaymentMethod(payment.getPaymentMethod());
        }
        if(payment.getPaymentMethod() != null) {
            payment.setPaymentMethod(payment.getPaymentMethod());
        }
        if(payment.getPaymentMethod() != null) {
            payment.setPaymentMethod(payment.getPaymentMethod());
        }

        return new ResponseEntity<>("Payment updated", HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        paymentService.deletePayment(id);
        return new ResponseEntity<>("Payment deleted", HttpStatus.OK);
    }
    
}

