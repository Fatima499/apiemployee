package com.zoologie.fr.apiemployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zoologie.fr.apiemployee.model.Profession;
import com.zoologie.fr.apiemployee.service.ProfessionService;

@RestController
@CrossOrigin
public class ProfessionController {
	@Autowired
	private ProfessionService professionService;
	
	@GetMapping(value="/profession/{id}", produces="application/json")
	public Profession getProfessionById(@PathVariable Integer id) {
		return this.professionService.getProfessionById(id);
	}
	
	@GetMapping(value="/profession/all", produces="application/json")
	public 	Iterable<Profession> getAllProfession() {
		return this.professionService.getAllProfession();
	}
	
	
	@DeleteMapping(value="/profession/{id}", produces="application/json")
	public void deleteProfessionById(@PathVariable Integer id) {
		 this.professionService.deleteProfessionById(id);
	}
	
	@DeleteMapping(value="/profession/all", produces="application/json")
	public void deleteAllProfession() {
		 this.professionService.deleteAllProfession();
	}
	
	
	
}
