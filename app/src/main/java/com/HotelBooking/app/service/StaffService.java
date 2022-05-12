package com.HotelBooking.app.service;

import com.HotelBooking.app.model.Role;
import com.HotelBooking.app.model.Staff;
import com.HotelBooking.app.repository.RoleRepository;
import com.HotelBooking.app.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class StaffService implements UserDetailsService {


	private final StaffRepository staffRepository ;

	private final RoleRepository roleRepository ;

	private final BCryptPasswordEncoder passwordEncoder;




	public List<Staff> getAllStaffs() {
		log.info("Getting all staffs");
		return staffRepository.findAll();
	}

	public Staff getStaffById(Long id) {
		log.info("Getting staff: {}", id);
		Optional<Staff> staff = staffRepository.findById(id);
		if(staff.isPresent()) {
			return staff.get();
		}
		return null;
	}

	public Staff addStaff(Staff staff) {
		log.info("Adding staff: {}", staff.getUsername());
		staff.setPassword(passwordEncoder.encode(staff.getPassword()));

		return staffRepository.save(staff);
	}


	public Staff updateStaff(Staff staff) {
		log.info("Updating staff: {}", staff.getUsername());
		staffRepository.save(staff);
		return staff;
	}
	public void deleteStaff(Long id) {
		log.info("Deleting staff: {}", id);
		staffRepository.deleteById(id);
	}

	@Override

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Staff staff = staffRepository.findByUsername(username);
		if (staff == null ){
			log.error("User not found");
			throw new UsernameNotFoundException("User not found");
		}else {
			log.info("User found: {}", username);

		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		staff.getRoles().forEach(role -> { authorities.add(new SimpleGrantedAuthority(role.getName())); });

		return new User(staff.getUsername(), staff.getPassword(), authorities);
	}
}



