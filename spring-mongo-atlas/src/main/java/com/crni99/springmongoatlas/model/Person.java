package com.crni99.springmongoatlas.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "person")
public class Person {

	@Id
	private String personId;
	private String firstName;
	private String lastName;
	private Integer age;
	private List<String> hobbies;
	private List<Address> addresses;
}
