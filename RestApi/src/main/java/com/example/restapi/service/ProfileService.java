package com.example.restapi.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.restapi.model.Profiles;

public interface ProfileService extends MongoRepository<Profiles, Integer>{

	Iterable<Profiles> findByFirstNameAndLastName(String firstName, String lastName);
	
	Iterable<Profiles> findByFirstName(String firstName);
	
	Iterable<Profiles> findByLastName(String lastName);
}
