package com.example.demo.security.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.ERole;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}
	
	public Iterable<User> ALLUser(){
		return userRepository.findAll();
	}
	
	public List<User> findAllUsers(){
		//List<User> my_user = new ArrayList<User>();
		for (int i=0; i<userRepository.findAllUsers().size();i++) {
			
			if(userRepository.findAllUsers().get(i).getRoles().equals(ERole.ROLE_USER)) {
				System.out.println("This is a patient");
			}
		}
		
		return userRepository.findAllUsers();
	}
	
	
	public void followPatient( Long patient_id, Long medecin_id){
		userRepository.followPatient( patient_id, medecin_id);
	}
	
	public User findPatientByUsername(String patient_name){
		return userRepository.findPatientByUsername(patient_name);
	}
	
	

	public void deleteDoctor(Long id){
		 userRepository.setForeignKey();
		 userRepository.deleteTheDoctor(id);
		 userRepository.deleteRoleDoctor(id);
	}

}