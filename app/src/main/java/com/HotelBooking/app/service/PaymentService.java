package com.HotelBooking.app.service;

import com.HotelBooking.app.model.Payment;
import com.HotelBooking.app.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {


	private final PaymentRepository paymentRepository;

	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	public Payment getPaymentById(Long id) {
		Optional<Payment> payment = paymentRepository.findById(id);
		if(payment.isPresent()) {
			return payment.get();
		}
		return null;
	}

	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	public void updatePayment(Payment payment) {
		paymentRepository.save(payment);
	}


	public void deletePayment(Long id) {
		paymentRepository.deleteById(id);
	}
}





