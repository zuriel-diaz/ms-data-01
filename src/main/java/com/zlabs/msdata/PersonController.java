package com.zlabs.msdata;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	PersonRepository personRepository;
	
	public Person store(@Valid @RequestBody Person person) {
		return personRepository.save(person);
	}
	
}
