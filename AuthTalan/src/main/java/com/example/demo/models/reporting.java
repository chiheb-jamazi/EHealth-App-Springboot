package com.example.demo.models;
import javax.persistence.*;
@Entity
@Table(name = "reporting")
public class reporting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Long iddetails;
	private String datedetails;
	private String Message;
	public reporting() {
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getIddetails() {
		return iddetails;
	}

	public void setIddetails(Long iddetails) {
		this.iddetails = iddetails;
	}

	public String getDatedetails() {
		return datedetails;
	}

	public void setDatedetails(String datedetails) {
		this.datedetails = datedetails;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	
	
}