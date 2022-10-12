package com.crni99.springmongoatlas.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crni99.springmongoatlas.model.Person;
import com.crni99.springmongoatlas.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person createPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}

	@GetMapping
	public List<Person> getPersons() {
		return personService.findAllPersons();
	}

	@GetMapping("/{personId}")
	public Person getPersonsById(@PathVariable String personId) {
		return personService.getPersonById(personId);
	}

	@GetMapping("/gender/{gender}")
	public List<Person> getByPersonGender(@PathVariable String gender) {
		return personService.getByPersonGender(gender);
	}

	@GetMapping("/date")
	public List<Person> getByPersonAge(
			@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
			@RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
		return personService.findByDateBetween(from, to);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Person modifyPerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}

	@DeleteMapping("/{personId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String deletePerson(@PathVariable String personId) {
		return personService.deletePerson(personId);
	}
}
