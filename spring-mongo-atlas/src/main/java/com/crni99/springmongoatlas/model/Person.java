package com.crni99.springmongoatlas.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

// @JsonInclude - Ignore Null Fields

@Data
@Builder
@Document(collection = "persons")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

	@Id
	private String personId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private Gender gender;
	private Address address;
	private List<String> hobbies;
}
