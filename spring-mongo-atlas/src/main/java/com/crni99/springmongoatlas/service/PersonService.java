package com.crni99.springmongoatlas.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.support.PersistableIsNewStrategy;
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

	public List<Person> getByPersonAge(Integer minAge, Integer maxAge) {
		return personRepository.findPersonByAgeBetween(minAge, maxAge);
	}

	public Person updatePerson(Person personRequested) {
		// get the existing document from DB
		// populate new value from request to existing object/entity/document
		Person existingPerson = personRepository.findById(personRequested.getPersonId()).get();
		existingPerson.setFirstName(personRequested.getFirstName());
		existingPerson.setLastName(personRequested.getLastName());
		existingPerson.setDob(personRequested.getDob());
		existingPerson.setGender(personRequested.getGender());
		existingPerson.setAddress(personRequested.getAddress());
		existingPerson.setHobbies(personRequested.getHobbies());
		return personRepository.save(existingPerson);
	}

	public String deletePerson(String personId) {
		personRepository.deleteById(personId);
		return personId + " person deleted from dashboard.";
	}
}
