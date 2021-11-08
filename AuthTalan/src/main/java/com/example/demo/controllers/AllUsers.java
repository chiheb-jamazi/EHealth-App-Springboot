package com.example.demo.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.models.User;

import com.example.demo.security.services.UserDetailsServiceImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AllUsers {

	@Autowired
	private UserDetailsServiceImpl service;
	

	@GetMapping("/AllUsers")
	public Iterable<User> Allusers(){
		return service.ALLUser();
	}
	
	@GetMapping(value = "/findAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAllUsers(){
		return service.findAllUsers();
	}
	
	
	@PostMapping("/followPatient/{patient_id}/{medecin_id}")
	public void followPatient(@PathVariable Long patient_id, @PathVariable Long medecin_id){
		service.followPatient(patient_id, medecin_id);
	}
	
	@GetMapping("/findPatientByUsername/{patient_name}")
	//@RequestMapping(value = "/findPatientByUsername/{usenarme}", method = RequestMethod.POST)
	public User findPatientByUsername(@PathVariable String patient_name){
		return service.findPatientByUsername(patient_name);
	}
	
	@DeleteMapping("/deleteDoctor/{id}")
	public void deleteDoctor(@PathVariable Long id){
		service.deleteDoctor(id);
	}
	
}
