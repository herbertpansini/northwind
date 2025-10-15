package br.com.northwind.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    @Id
    @Column(name = "CustomerID", length = 5, nullable = false)
    String id;

    @Column(name = "CompanyName", nullable = false)
    String companyName;

    @Column(name = "ContactName")
    String contactName;

    @Column(name = "ContactTitle")
    String contactTitle;

    @Column(name = "Address")
    String address;

    @Column(name = "City")
    String city;

    @Column(name = "Region")
    String region;

    @Column(name = "PostalCode")
    String postalCode;

    @Column(name = "Country")
    String country;

    @Column(name = "Phone")
    String phone;

    @Column(name = "Fax")
    String fax;
}