package com.example.restapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.Profiles;
import com.example.restapi.service.ProfileService;

@RestController
public class ProfilesController {

	@Autowired
	private ProfileService profileService;
	
	@PostMapping("/profiles")
	Profiles create(@RequestBody Profiles profiles) {
		return profileService.save(profiles);
	}
	@GetMapping("/profiles")
	Iterable<Profiles> read(){
		return profileService.findAll();
	}
	
	@PutMapping("/profiles")
	Profiles update(@RequestBody Profiles profiles) {
		return profileService.save(profiles);
	}
	
	@DeleteMapping("/profiles/{id}")
	void delete(@PathVariable Integer id) {
		profileService.deleteById(id);
	}
	
	@GetMapping("profiles/{id}")
	Optional<Profiles> findById(@PathVariable Integer id){
		return profileService.findById(id);
	}
	
	@GetMapping("profiles/search")
	Iterable<Profiles> findByQuery(@RequestParam(value="first", required = false) String firstName,
								   @RequestParam(value="last", required = false) String lastName){
		if (firstName!=null && lastName!=null) {
			return profileService.findByFirstNameAndLastName(firstName, lastName);
		}
		else if(firstName!=null) {
			return profileService.findByFirstName(firstName);
		}
		else if(lastName!=null) {
			return profileService.findByLastName(lastName);
		}else {
			return profileService.findAll();
		}
		
	}
	
	
}
