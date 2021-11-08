

package com.example.demo.models;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date date;
	private float heartrate;
	private int steps;
	private float calories;
	private float oxygene;
	private float temperature;
	private float weight_kilo;
	private float hours_asleep;
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private User user;

	public Patient() {

	}
	

	public Patient(Integer id, Date date, float heartrate, int steps, float calories, float oxygene, float temperature,
			float weight_kilo, float hours_asleep) {
		super();
		this.id = id;
		this.date = date;
		this.heartrate = heartrate;
		this.steps = steps;
		this.calories = calories;
		this.oxygene = oxygene;
		this.temperature = temperature;
		this.weight_kilo = weight_kilo;
		this.hours_asleep = hours_asleep;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getHeartrate() {
		return heartrate;
	}

	public void setHeartrate(float heartrate) {
		this.heartrate = heartrate;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public float getCalories() {
		return calories;
	}

	public void setCalories(float calories) {
		this.calories = calories;
	}

	public float getOxygene() {
		return oxygene;
	}

	public void setOxygene(float oxygene) {
		this.oxygene = oxygene;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getWeight_kilo() {
		return weight_kilo;
	}

	public void setWeight_kilo(float weight_kilo) {
		this.weight_kilo = weight_kilo;
	}

	public float getHours_asleep() {
		return hours_asleep;
	}

	public void setHours_asleep(float hours_asleep) {
		this.hours_asleep = hours_asleep;
	}

	

	


	
}