

package com.example.demo.models;


import javax.persistence.*;

@Entity
@Table(name = "bouteille")
public class bouteille {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private float pourcentage;

	public bouteille() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(float pourcentage) {
		this.pourcentage = pourcentage;
	}

	public bouteille(Integer id, float pourcentage) {
		super();
		this.id = id;
		this.pourcentage = pourcentage;
	}

	
}