package com.zoologie.fr.apiemployee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zoologie.fr.apiemployee.model.Adress;

@Repository
public interface AdressRepository extends CrudRepository<Adress,Integer>{

}
