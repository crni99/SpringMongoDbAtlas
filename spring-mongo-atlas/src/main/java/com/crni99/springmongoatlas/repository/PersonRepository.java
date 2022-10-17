package com.crni99.springmongoatlas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crni99.springmongoatlas.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

	List<Person> findPersonsByGender(String gender);

	List<Person> findPersonsByDobBetween(LocalDate from, LocalDate to);

	List<Person> findPersonsByHobbiesContaining(List<String> hobbies);

	String deletePersonsByGender(String gender);

}
