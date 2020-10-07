package br.com.northwind.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.northwind.model.Supplier;
import br.com.northwind.service.SupplierService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

	private final SupplierService supplierService;
	
	@GetMapping
	public ResponseEntity<Page<Supplier>> findAll(Pageable pageable) {
		Page<Supplier> suppliers = this.supplierService.findAll(pageable); 
		return ResponseEntity.ok(suppliers);
	}
}