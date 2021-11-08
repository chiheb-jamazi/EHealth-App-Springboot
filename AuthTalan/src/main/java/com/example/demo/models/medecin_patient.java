package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*", maxAge = 3600)
@Entity
@Table( name = "medecin_patient", uniqueConstraints = {@UniqueConstraint(columnNames= {"medecin_id", "patient_id"})})

public class medecin_patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long patient_id;
	private Long medecin_id;
	
	public medecin_patient() {

	}
	
	public medecin_patient(Long patient_id, Long medecin_id) {
		super();
		this.patient_id = patient_id;
		this.medecin_id = medecin_id;
	}

	
	public Long getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Long patient_id) {
		this.patient_id = patient_id;
	}
	public Long getMedecin_id() {
		return medecin_id;
	}
	public void setMedecin_id(Long medecin_id) {
		this.medecin_id = medecin_id;
	}
}
