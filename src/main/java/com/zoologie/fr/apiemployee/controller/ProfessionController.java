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

import com.zoologie.fr.apiemployee.model.Profession;
import com.zoologie.fr.apiemployee.service.ProfessionService;

@RestController
@CrossOrigin
public class ProfessionController {
	@Autowired
	private ProfessionService professionService;
	
	/**
	 * GET a profesion by id
	 * @param id
	 * @return a profession
	 */
	@GetMapping(value="/professions/{id}")
	public Profession getProfessionById(@PathVariable Integer id) {
		return this.professionService.getProfessionById(id);
	}
	
	/**
	 * GET all professions
	 * @return a Iterable that contains all profession
	 */
	@GetMapping(value="/professions")
	public 	Iterable<Profession> getAllProfession() {
		return this.professionService.getAllProfession();
	}
	
	/**
	 * POST :Create a new profession
	 * @param profession
	 * @return a creation code 201 and URI to created resource
	 */
	@PostMapping(value="/professions")
	public ResponseEntity<Profession> addProfession(@RequestBody Profession profession ) {
		Profession professionAdded = this.professionService.saveProfession(profession);
		if(Objects.isNull(professionAdded)) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(professionAdded.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	/**
	 * PUT : update a profession
	 * @param profession
	 */
	@PutMapping(value="professions")
	private void updateProfession(@RequestBody Profession profession) {
		this.professionService.saveProfession(profession);
	}
	
	/**
	 * Delete a profession by id
	 * @param id
	 */
	@DeleteMapping(value="/professions/{id}")
	public void deleteProfessionById(@PathVariable Integer id) {
		 this.professionService.deleteProfessionById(id);
	}
	
	/**
	 * Delete all professions
	 */
	@DeleteMapping(value="/professions")
	public void deleteAllProfession() {
		 this.professionService.deleteAllProfession();
	}
	
	
	
}
