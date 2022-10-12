package com.crni99.springmongoatlas.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

	private String placeOfBirth;
	private String country;
	private String city;
	private String zipCode;
}
