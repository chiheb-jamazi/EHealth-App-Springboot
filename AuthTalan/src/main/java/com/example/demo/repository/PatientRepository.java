package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Patient;
import com.example.demo.models.User;
import com.example.demo.models.medecin_patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
	
	//@Query("select p from Patient p join p.user u where u.id=:user_id")
	@Query("select p from Patient p where p.user.id=:user_id")
	public List<Patient> findPatientDetails(@Param("user_id") Long user_id);
	
	@Query("select p from medecin_patient p where p.medecin_id=:id")
	public List<medecin_patient> findPatientMedecin(@Param("id") Long id);

}
