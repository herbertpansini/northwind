package br.com.northwind.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
public class EmployeeDto {
    @Id
    private Long id;

    @NotEmpty
    @Max(20)
    private String lastName;

    @NotEmpty
    @Max(10)
    private String firstName;

    @Max(30)
    private String title;

    @Max(25)
    private String titleOfCourtesy;

    private LocalDateTime birthDate;
    private LocalDateTime hireDate;

    @Max(60)
    private String address;

    @Max(15)
    private String city;

    @Max(15)
    private String region;

    @Max(10)
    private String postalCode;

    @Max(15)
    private String country;

    @Max(24)
    private String homePhone;

    @Max(4)
    private String extension;

    private String notes;

    private Integer reportsTo;

    @Max(255)
    private String photoPath;
}