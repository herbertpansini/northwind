package br.com.northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.northwind.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}