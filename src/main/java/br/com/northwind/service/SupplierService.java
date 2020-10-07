package br.com.northwind.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.northwind.model.Supplier;

public interface SupplierService {
	
	Page<Supplier> findAll(Pageable pageable); 
}
