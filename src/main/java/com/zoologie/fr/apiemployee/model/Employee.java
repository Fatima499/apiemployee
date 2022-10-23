package com.zoologie.fr.apiemployee.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@Column(name="nom", nullable=false, length=32)
	private String nom; 
	
	@Column(name="prenom", nullable=false, length=32)
	private String prenom;
	
	@Column(name="date_naissance", nullable=false)
	private Date dateNaissance;
	
	@Column(name="email", nullable=false, length=100)
	private String email;
	
	@Column(name="email", nullable=false, length=32)
	private String contact;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="adresse_id", referencedColumnName = "id")
	private Integer adresse;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="profession_id", referencedColumnName = "id")
	private String  profession;

	@Column(name="seniority", nullable=false)
	private Integer seniority;
}
