package com.HotelBooking.app.service;

import com.HotelBooking.app.model.Extra;
import com.HotelBooking.app.repository.ExtraRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExtraService {


	private final ExtraRepository  extraRepository;

	public ExtraService(ExtraRepository extraRepository) {
		this.extraRepository = extraRepository;
	}

	public List<Extra> getAllExtras() {
		return extraRepository.findAll();
	}

	public Extra getExtraByid(Long id) {
		Optional<Extra> extra = extraRepository.findById(id);
		if(extra.isPresent()) {
			return extra.get();
		}
		return null;
	}

	public Extra addExtra(Extra extra) {
		return extraRepository.save(extra);
	}

	public void updateExtra(Extra extra) {
		extraRepository.save(extra);
	}
	public void deleteExtra(Long id) {
		extraRepository.deleteById(id);
	}
}



