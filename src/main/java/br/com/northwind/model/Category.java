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
@Table(name = "Categories")
@Data
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryID", nullable = false)
	private Long id;
	
	@Column(name = "CategoryName", nullable = false)
	private String name;
	
	@Column(name = "Description")
	private String description;	

	@OneToMany(mappedBy = "category")
	private List<Product> products;
}