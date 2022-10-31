package com.zoologie.fr.apiemployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoologie.fr.apiemployee.model.Profession;
import com.zoologie.fr.apiemployee.repository.ProfessionRepository;

@Service
public class ProfessionService {
	@Autowired
	private ProfessionRepository professionReposity;
	
	
	public Profession getProfessionById(Integer id) {
		return this.professionReposity.findById(id).get();
	}
	
	public Iterable<Profession> getAllProfession(){
		return this.professionReposity.findAll();
	}
	
	public Profession saveProfession(Profession profession) {
		return this.professionReposity.save(profession);
	}
	
	
	
	public void deleteProfession(Profession profession) {
		this.professionReposity.delete(profession);
	}
	
	public void deleteProfessionById(Integer id) {
		this.professionReposity.deleteById(id);
	}
	
	public void deleteAllProfession() {
		this.professionReposity.deleteAll();
	}
}
