package br.com.northwind.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Suppliers")
@Data
public class Supplier implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SupplierID", nullable = false)
	private Long id;
	
	@Column(name = "CompanyName", nullable = false)
	private String name;
		
	@Column(name = "ContactName")
	private String contactName;
	
	@Column(name = "ContactTitle")
	private String contactTitle;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "Region")
	private String region;
	
	@Column(name = "PostalCode")
	private String postalCode;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "Fax")
	private String fax;
	
	@Column(name = "HomePage")
	private String homePage;
	
	@OneToMany(mappedBy = "supplier")
	private List<Product> products;
}
