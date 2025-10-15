package br.com.northwind.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Employees")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID", nullable = false)
    Long id;

    @Column(name = "LastName", length = 20, nullable = false)
    String lastName;

    @Column(name = "FirstName", length = 10, nullable = false)
    String firstName;

    @Column(name = "Title", length = 30)
    String title;

    @Column(name = "TitleOfCourtesy", length = 25)
    String titleOfCourtesy;

    @Column(name = "BirthDate")
    LocalDateTime birthDate;

    @Column(name = "HireDate")
    LocalDateTime hireDate;

    @Column(name = "Address", length = 60)
    String address;

    @Column(name = "City", length = 15)
    String city;

    @Column(name = "Region", length = 15)
    String region;

    @Column(name = "PostalCode", length = 10)
    String postalCode;

    @Column(name = "Country", length = 15)
    String country;

    @Column(name = "HomePhone", length = 24)
    String homePhone;

    @Column(name = "Extension", length = 4)
    String extension;

    @Column(name = "Notes")
    String notes;

    @Column(name = "ReportsTo")
    Integer reportsTo;

    @Column(name = "PhotoPath", length = 255)
    String photoPath;
}