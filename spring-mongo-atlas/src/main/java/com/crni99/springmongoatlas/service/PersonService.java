package com.crni99.springmongoatlas.service;

import java.time.LocalDate;
import java.util.List;

import com.crni99.springmongoatlas.model.Person;

public interface PersonService {

	Person addPerson(Person person);

	List<Person> findAllPersons();

	Person getPersonById(String personId);

	List<Person> getByPersonGender(String gender);

	List<Person> findByDateBetween(LocalDate from, LocalDate to);

	List<Person> findByHobbies(List<String> hobbies);

	Person updatePerson(Person personRequested);

	String deletePerson(String personId);

	String deletePersonsByGender(String gender);

}
