package com.example.demo.security.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Patient;
import com.example.demo.models.medecin_patient;
import com.example.demo.models.reporting;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.reportingRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repo;
	
	@Autowired
	private reportingRepository repoo;
	
	
	public PatientService() {
	}
	
	public PatientService(PatientRepository repo,reportingRepository repoo) {
		super();
		this.repo = repo;
		this.repoo = repoo;

	}
	
	/*public Optional<Patient> showPatient(int id_user){
		return repo.findById(id_user);
	}*/
	
	public List<Patient> getPatientDetails(Long user_id) {
		return repo.findPatientDetails(user_id);	
	}
	
	public List<medecin_patient> findPatientMedecin(Long id) {
		return repo.findPatientMedecin(id);	
	}
	public void Addreporting(Long iddetails,String datedetails,String Message) {
		 repoo.Addreporting(iddetails,datedetails,Message);	
	}
	public List<reporting> findreporting(Long id) {
		return repoo.findReporting(id);	
	}
	
	public List<reporting> findLatestReporting(Long id) {
		return repoo.findLatestReporting(id);	
	}

}
