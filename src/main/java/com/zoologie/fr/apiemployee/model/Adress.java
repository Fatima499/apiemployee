package com.zoologie.fr.apiemployee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="adress")
public class Adress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="numero", nullable=false)
	private Integer numero;
	
	@Column(name="rue", nullable=false, length = 100 )
	private String rue;
	
	@Column(name="complement", nullable=true, length = 100 )
	private String complement; 
	
	@Column(name="code_postal", nullable = false)
	private Integer code_postal;
	
	@Column(name="ville", nullable= false, length = 32)
	private String ville;
	
	@Column(name="pays", nullable= false, length = 32)
	private String pays;

}
