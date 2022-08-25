package br.com.northwind.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Employees")
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID", nullable = false)
    private Long id;

    @Column(name = "LastName", length = 20, nullable = false)
    private String lastName;

    @Column(name = "FirstName", length = 10, nullable = false)
    private String firstName;

    @Column(name = "Title", length = 30)
    private String title;

    @Column(name = "TitleOfCourtesy", length = 25)
    private String titleOfCourtesy;

    @Column(name = "BirthDate")
    private LocalDateTime birthDate;

    @Column(name = "HireDate")
    private LocalDateTime hireDate;

    @Column(name = "Address", length = 60)
    private String address;

    @Column(name = "City", length = 15)
    private String city;

    @Column(name = "Region", length = 15)
    private String region;

    @Column(name = "PostalCode", length = 10)
    private String postalCode;

    @Column(name = "Country", length = 15)
    private String country;

    @Column(name = "HomePhone", length = 24)
    private String homePhone;

    @Column(name = "Extension", length = 4)
    private String extension;

    @Column(name = "Notes")
    private String notes;

    @Column(name = "ReportsTo")
    private Integer reportsTo;

    @Column(name = "PhotoPath", length = 255)
    private String photoPath;
}