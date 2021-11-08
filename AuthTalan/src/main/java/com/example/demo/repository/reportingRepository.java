package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Patient;
import com.example.demo.models.medecin_patient;
import com.example.demo.models.reporting;

public interface reportingRepository extends CrudRepository<reporting, Integer> {
	
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO reporting (iddetails,datedetails,Message) VALUES (:iddetails,:datedetails,:Message) ", nativeQuery = true)
	 void Addreporting(@Param("iddetails") Long iddetails, @Param("datedetails") String datedetails,@Param("Message") String Message);
	
	
	@Query("select p from reporting p where p.iddetails=:id")
	public List<reporting> findReporting(@Param("id") Long id);
	
	
	@Query(value = "select * from reporting p where p.iddetails=:id order by p.datedetails DESC LIMIT 3", nativeQuery = true)
	public List<reporting> findLatestReporting(@Param("id") Long id);
	
	
}
