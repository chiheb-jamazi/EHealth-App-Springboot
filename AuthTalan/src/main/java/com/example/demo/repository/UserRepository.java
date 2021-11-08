package com.example.demo.repository;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;
import com.example.demo.models.medecin_patient;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO medecin_patient (patient_id,medecin_id) VALUES (:patient_id,:medecin_id) ", nativeQuery = true)
	 void followPatient(@Param("patient_id") Long patient_id, @Param("medecin_id") Long medecin_id);
	
	@Query("select u from User u where u.username=:patient_name")
	public User findPatientByUsername(@Param("patient_name") String patient_name);
	
	@Query(value = "select u.password, u.email, u.username, u.id ,r.role_id, r.user_id from users u join user_roles r on u.id=r.user_id", nativeQuery = true)
	public List<User> findAllUsers();
	
	@Query(value = "select * from user_roles where user_id=:id", nativeQuery = true)
	public List<User> findUsersRoles(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM user_roles WHERE user_id=:id", nativeQuery = true)
	public void deleteRoleDoctor(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM users WHERE id=:id", nativeQuery = true)
	public void deleteTheDoctor(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query(value = "SET FOREIGN_KEY_CHECKS=0", nativeQuery = true)
	public void setForeignKey();
	
	
}