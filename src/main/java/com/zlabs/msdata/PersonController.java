package com.zlabs.msdata;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	PersonRepository personRepository;
	
	@PostMapping("/people")
	public Person store(@Valid @RequestBody Person person) {
		return personRepository.save(person);
	}
	
	@GetMapping("/people")
	public List<Person> getPeople(){
		return personRepository.findAll();
	}
	
	@GetMapping("/people/{id}")
	public Optional<Person> getPersonById(@PathVariable(value = "id") Long personId) {
		return personRepository.findById(personId);
	}
	
	@PutMapping("/people/{id}")
	public Person update(@PathVariable(value = "id") Long personId, @Valid @RequestBody Person personData) {
		Optional<Person> person = personRepository.findById(personId);
		Person data = null;
		
		if (person != null && ) {
			person.setFirstName( personData.getFirstName() );
			person.setLastName( personData.getLastName() );
			person.setEmail( personData.getEmail() );
			data = personRepository.save(person);
		}
		return data ;
	}
	
	
}
