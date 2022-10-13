package com.crni99.springmongoatlas.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crni99.springmongoatlas.model.Person;
import com.crni99.springmongoatlas.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	// CREATE , READ , UPDATE , DELETE

	public Person addPerson(Person person) {
		person.setPersonId(UUID.randomUUID().toString().split("-")[0]);
		return personRepository.save(person);
	}

	public List<Person> findAllPersons() {
		return personRepository.findAll();
	}

	public Person getPersonById(String personId) {
		return personRepository.findById(personId).get();
	}

	public List<Person> getByPersonGender(String gender) {
		return personRepository.findPersonsByGender(gender.toUpperCase());
	}

	public List<Person> findByDateBetween(LocalDate from, LocalDate to) {
		return personRepository.findPersonsByDobBetween(from, to);
	}

	public List<Person> findByHobbies(List<String> hobbies) {
		return personRepository.findPersonsByHobbiesContaining(hobbies);
	}

	public Person updatePerson(Person personRequested) {
		// get the existing document from DB
		// populate new value from request to existing object/entity/document
		Person existingPerson = personRepository.findById(personRequested.getPersonId()).get();

		if (personRequested.getFirstName() != null) {
			existingPerson.setFirstName(personRequested.getFirstName());
		}
		if (personRequested.getLastName() != null) {
			existingPerson.setLastName(personRequested.getLastName());
		}
		if (personRequested.getDob() != null) {
			existingPerson.setDob(personRequested.getDob());
		}
		if (personRequested.getGender() != null) {
			existingPerson.setGender(personRequested.getGender());
		}
		if (personRequested.getAddress() != null) {
			existingPerson.setAddress(personRequested.getAddress());
		}
		if (personRequested.getHobbies() != null) {
			existingPerson.setHobbies(personRequested.getHobbies());
		}

		return personRepository.save(existingPerson);
	}

	public String deletePerson(String personId) {
		personRepository.deleteById(personId);
		return personId + " person deleted from dashboard.";
	}
}
