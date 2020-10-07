package br.com.northwind.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Products")
@Data
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductID", nullable = false)
	private Long id;
	
	@Column(name = "ProductName", nullable = false)
	private String name;
	
	@ManyToOne
    @JoinColumn(name="CategoryID", nullable = false)
	private Category category;
	
	@ManyToOne
    @JoinColumn(name="SupplierID", nullable = false)
	private Supplier supplier;
	
	@Column(name = "QuantityPerUnit", nullable = true)
	private String quantityPerUnit;
	
	@Column(name = "UnitPrice", nullable = true)
	private Double unitPrice;
		
	@Column(name = "UnitsInStock", nullable = true)
	private Integer unitsInStock;
		
	@Column(name = "UnitsOnOrder", nullable = true)
	private Integer unitsOnOrder;
		
	@Column(name = "ReorderLevel", nullable = true)
	private Integer reorderLevel;
	
	@Column(name = "Discontinued", nullable = false)
	private Boolean discontinued;
}
