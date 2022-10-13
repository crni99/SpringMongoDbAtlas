package com.crni99.springmongoatlas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crni99.springmongoatlas.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

	List<Person> findPersonsByGender(String gender);

	public List<Person> findPersonsByDobBetween(LocalDate from, LocalDate to);

	public List<Person> findPersonsByHobbiesContaining(List<String> hobbies);

}
