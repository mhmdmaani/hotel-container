package com.HotelBooking.app.service;

import com.HotelBooking.app.model.Role;
import com.HotelBooking.app.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {


	private final RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	public Role getRoleById(Long id) {
		Optional<Role> role = roleRepository.findById(id);
		if(role.isPresent()) {
			return role.get();
		}
		return null;
	}

	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	public void updateRole(Role role) {
		roleRepository.save(role);
	}

	public void deleteRole(Long id) {
		roleRepository.deleteById(id);
	}
}



