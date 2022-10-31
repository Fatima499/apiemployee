package com.zoologie.fr.apiemployee.controller;

import java.net.URI;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	private  AdressService adressService;
	
	/**
	 * GET All addresses
	 * @return a Iterable that contains all adresses
	 */
	@GetMapping(value="/adresses")
	public Iterable<Adress> getAllAdress(){
		return this.adressService.getAllAdress();
	}
	
	/**
	 * GET a adress by id
	 * @param id
	 * @return a adress
	 */
	@GetMapping(value="/adresses/{id}")
	public Adress getAdressById(@PathVariable Integer id) {
		 return this.adressService.getAdressById(id);
	}
	
	/**
	 * POST : create a new adress
	 * @param adress
	 * @return a creation code 201 and URI to created resource
	 */
	@PostMapping(value="/adresses")
	public ResponseEntity<Adress> addAdress(@RequestBody Adress adress ) {
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
	
	/**
	 * PUT : update a adress
	 * @param adress
	 */
	@PutMapping(value="/adresses")
	private void updateAdress(@RequestBody Adress adress) {
		this.adressService.saveAdress(adress);
	}
	
	
	/**
	 * Delete a adress
	 * @param id
	 */
	@DeleteMapping(value="/adresses{id}")
	public void deleteAdressById(@PathVariable Integer id) {
		this.adressService.deleteAdressById(id);
	}
	
	/**
	 * Delete all addresses
	 */
	@DeleteMapping(value="/adresses")
	public void deleteAllAdress() {
		this.adressService.deleteAllAdress();
	}
	
	
	
}
