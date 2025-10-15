package br.com.northwind.service.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDto implements Serializable {
    private static final long serialVersionUID = 1L;

    String id;
    String companyName;
    String contactName;
    String contactTitle;
    String address;
    String city;
    String region;
    String postalCode;
    String country;
    String phone;
    String fax;
}