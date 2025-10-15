package br.com.northwind.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Supplier implements BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SupplierID", nullable = false)
	Long id;
	
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
	
	@Column(name = "HomePage")
	String homePage;
	
	@JsonIgnoreProperties(value = {"supplier"}, allowSetters = true)
	@OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Product> products = new HashSet<>();
}