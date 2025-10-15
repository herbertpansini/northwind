package br.com.northwind.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product implements BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductID", nullable = false)
	Long id;
	
	@Column(name = "ProductName", nullable = false)
	String name;

	@JsonIgnoreProperties(value = "products")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CategoryID", nullable = false)
	Category category;

	@JsonIgnoreProperties(value = "suppliers")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SupplierID", nullable = false)
	Supplier supplier;

	String quantityPerUnit;

	Double unitPrice;

	Integer unitsInStock;

	Integer unitsOnOrder;

	Integer reorderLevel;
	
	@Column(nullable = false)
	Boolean discontinued;
}