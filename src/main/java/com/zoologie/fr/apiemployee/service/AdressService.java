package com.zoologie.fr.apiemployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoologie.fr.apiemployee.model.Adress;
import com.zoologie.fr.apiemployee.repository.AdressRepository;

@Service
public class AdressService {
	@Autowired
	private AdressRepository adressRepository;

	public Adress getAdressById(Integer id) {
		return adressRepository.findById(id).get();
	}

	public Iterable<Adress> getAllAdress() {
		return adressRepository.findAll();
	}

	public Adress saveAdress(Adress adress) {
		return adressRepository.save(adress);
	}

	public void deleteAdress(Adress adress) {
		adressRepository.delete(adress);
	}

	public void deleteAllAdress() {
		adressRepository.deleteAll();
	}

	public void deleteAdressById(Integer id) {
		adressRepository.deleteById(id);
	}

}
