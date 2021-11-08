package com.example.demo.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Patient;
import com.example.demo.models.medecin_patient;
import com.example.demo.models.reporting;
import com.example.demo.security.services.PatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientController {
	
	@Autowired
	private PatientService service;
	
	
	/*@GetMapping("/showPatient")
	@ResponseBody
	public Optional<Patient> showPatient(@RequestParam int id_user){
		return service.showPatient(id_user);
	}*/ 
	
	@GetMapping(value = "getPatientDetails/{user_id}")
    @ResponseBody
	public List<Patient> getPatientDetails(@PathVariable("user_id") Long user_id) {

		return service.getPatientDetails(user_id);
	}
	
	@GetMapping(value = "findPatientMedecin/{id}")
    @ResponseBody
	public List<medecin_patient> findPatientMedecin(@PathVariable("id") Long id) {

		return service.findPatientMedecin(id);
	}
	@PostMapping("/Addreporting/{iddetails}/{datedetails}/{Message}")
	public void Addreporting(@PathVariable Long iddetails, @PathVariable String datedetails,@PathVariable String Message){
		service.Addreporting(iddetails, datedetails, Message);
	}
	
	@GetMapping(value = "findreporting/{id}")
    @ResponseBody
	public List<reporting> findreporting(@PathVariable("id") Long id) {
		return service.findreporting(id);
	}
	
	@GetMapping(value = "findLatestReporting/{id}")
    @ResponseBody
	public List<reporting> findLatestReporting(@PathVariable("id") Long id) {
		return service.findLatestReporting(id);
	}


	
}
