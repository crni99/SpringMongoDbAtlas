package com.crni99.springmongoatlas.repository;

import com.crni99.springmongoatlas.model.Person;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PersonRepository extends MongoRepository<Person, String> {

	@Query(value = "{ 'age' : { $gt : ?0, $lt : ?1}}")
	List<Person> findPersonByAgeBetween(Integer min, Integer max);
}
