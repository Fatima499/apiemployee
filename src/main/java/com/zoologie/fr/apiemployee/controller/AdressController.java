package com.zoologie.fr.apiemployee.controller;

import java.net.URI;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zoologie.fr.apiemployee.model.Adress;
import com.zoologie.fr.apiemployee.service.AdressService;

@RestController
@CrossOrigin
public class AdressController {
	
	@Autowired
	private AdressService adressService;
	
	@GetMapping(value="/adress/all", produces ="application/json")
	public Iterable<Adress> getAllAdress(){
		return this.adressService.getAllAdress();
	}
	
	@GetMapping(value="/adress/{id}", produces="application/json")
	public Adress getAdressById(@PathVariable Integer id) {
		 return this.adressService.getAdressById(id);
	}
	
	@PutMapping(value="/adress", produces="application/json")
	public ResponseEntity<Adress> updateAdress(@RequestBody Adress adress ) {
		Adress adressAdded = this.adressService.saveAdress(adress);
		if(Objects.isNull(adressAdded)) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(adressAdded.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(value="/adress/{id}", produces="application/json")
	public void deleteAdressById(@PathVariable Integer id) {
		this.adressService.deleteAdressById(id);
	}
	
	@DeleteMapping(value="/adress/all", produces="application/json")
	public void deleteAllAdress() {
		this.adressService.deleteAllAdress();
	}
	
	
	
}
