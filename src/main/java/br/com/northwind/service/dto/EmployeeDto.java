package br.com.northwind.service.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto implements BaseDto, Serializable {
    private static final long serialVersionUID = 1L;
    Long id;

    @NotEmpty
    @Max(20)
    String lastName;

    @NotEmpty
    @Max(10)
    String firstName;

    @Max(30)
    String title;

    @Max(25)
    String titleOfCourtesy;

    LocalDateTime birthDate;
    LocalDateTime hireDate;

    @Max(60)
    String address;

    @Max(15)
    String city;

    @Max(15)
    String region;

    @Max(10)
    String postalCode;

    @Max(15)
    String country;

    @Max(24)
    String homePhone;

    @Max(4)
    String extension;

    String notes;

    Integer reportsTo;

    @Max(255)
    String photoPath;
}