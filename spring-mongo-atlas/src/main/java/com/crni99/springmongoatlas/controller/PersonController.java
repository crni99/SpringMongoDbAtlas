package com.crni99.springmongoatlas.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crni99.springmongoatlas.model.Person;
import com.crni99.springmongoatlas.service.PersonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/persons")
public class PersonController {

	private static final String responseCodeOK = "200";
	private static final String responseCodeCreated = "201";
	private static final String responseCodeAccepted = "202";

	// @Tag for sorting endpoints by name
	private static final String tagGet = "1. GET";
	private static final String tagPost = "2. POST";
	private static final String tagPut = "3. PUT";
	private static final String tagDelete = "4. DELETE";

	@Autowired
	private PersonService personService;

	@Tag(name = tagPost)
	@PostMapping
	@Operation(summary = "Create person", responses = {
			@ApiResponse(description = "Create person success", responseCode = responseCodeCreated, content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))) })
	public Person createPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}

	@Tag(name = tagGet)
	@GetMapping
	@Operation(summary = "Get persons", responses = {
			@ApiResponse(description = "Get persons success", responseCode = responseCodeOK, content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))) })
	public List<Person> getPersons() {
		return personService.findAllPersons();
	}

	@Tag(name = tagGet)
	@GetMapping("/{personId}")
	@Operation(summary = "Get person", responses = {
			@ApiResponse(description = "Get person success", responseCode = responseCodeOK, content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))) })
	public Person getPersonsById(@PathVariable String personId) {
		return personService.getPersonById(personId);
	}

	@Tag(name = tagGet)
	@GetMapping("/gender/{gender}")
	@Operation(summary = "Get person by gender", responses = {
			@ApiResponse(description = "Get person by gender success", responseCode = responseCodeOK, content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))) })
	public List<Person> getByPersonGender(@PathVariable String gender) {
		return personService.getByPersonGender(gender);
	}

	@Tag(name = tagGet)
	@GetMapping("/date")
	@Operation(summary = "Get persons between two dates of birth", responses = {
			@ApiResponse(description = "Get persons between two dates of birth success", responseCode = responseCodeOK, content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))) })
	public List<Person> getByPersonAge(
			@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
			@RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
		return personService.findByDateBetween(from, to);
	}

	@Tag(name = tagGet)
	@GetMapping("/hobbies")
	@Operation(summary = "Get persons by list of hobbies", responses = {
			@ApiResponse(description = "Get persons by list of hobbies success", responseCode = responseCodeOK, content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))) })
	public List<Person> getByHobbies(@RequestParam("hobbies") List<String> hobbies) {
		return personService.findByHobbies(hobbies);
	}

	@Tag(name = tagPut)
	@PutMapping
	@Operation(summary = "Update person", responses = {
			@ApiResponse(description = "Update person success", responseCode = responseCodeAccepted, content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))) })
	public Person modifyPerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}

	@Tag(name = tagDelete)
	@DeleteMapping("/{personId}")
	@Operation(summary = "Delete person", responses = {
			@ApiResponse(description = "Delete person success", responseCode = responseCodeAccepted, content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))) })
	public String deletePerson(@PathVariable String personId) {
		return personService.deletePerson(personId);
	}
}
