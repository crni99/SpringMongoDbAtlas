package com.crni99.springmongoatlas.service;

import java.time.LocalDate;
import java.util.List;

import com.crni99.springmongoatlas.model.Person;

public interface PersonService {

	public Person addPerson(Person person);

	public List<Person> findAllPersons();

	public Person getPersonById(String personId);

	public List<Person> getByPersonGender(String gender);

	public List<Person> findByDateBetween(LocalDate from, LocalDate to);

	public List<Person> findByHobbies(List<String> hobbies);

	public Person updatePerson(Person personRequested);

	public String deletePerson(String personId);

}
