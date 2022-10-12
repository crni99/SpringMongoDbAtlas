package com.crni99.springmongoatlas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.crni99.springmongoatlas.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

	List<Person> findPersonsByGender(String gender);

	@Query("{'date' : { $gte: ?0, $lte: ?1 } }") 
	public List<Person> findByDateBetween(Date from, Date to);
	
}
