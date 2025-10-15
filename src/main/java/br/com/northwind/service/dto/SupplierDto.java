package br.com.northwind.service.dto;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupplierDto implements BaseDto, Serializable {
	private static final long serialVersionUID = 1L;

	Long id;
	String name;
	String contactName;
	String contactTitle;
	String address;
	String city;
	String region;
	String postalCode;
	String country;
	String phone;
	String fax;
	String homePage;	
}