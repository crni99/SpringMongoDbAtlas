package com.crni99.springmongoatlas.repository;

import com.crni99.springmongoatlas.model.Person;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

	List<Person> findPersonByGender(String gender);
}
