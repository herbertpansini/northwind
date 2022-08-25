package br.com.northwind.controller;

import br.com.northwind.service.dto.SupplierByCityDto;
import br.com.northwind.service.dto.SupplierDto;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.northwind.service.SupplierService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

	private final Logger log = LoggerFactory.getLogger(SupplierController.class);
	private final SupplierService supplierService;

	@GetMapping("/by-city")
	@Timed
	public ResponseEntity<Page<SupplierByCityDto>> findByCompanyNameContainingIgnoreCaseOrderByCompanyName(@RequestParam(value = "companyName", required = false, defaultValue = "") String companyName, Pageable pageable) {
		log.debug("Recuperar suppliers por companyName : {}", companyName);
		return ResponseEntity.ok(this.supplierService.findByCompanyNameContainingIgnoreCaseOrderByCompanyName(companyName, pageable));
	}
	
	@GetMapping
	@Timed
	public ResponseEntity<Page<SupplierDto>> findAll(Pageable pageable) {
		log.debug("Recuperar uma coleção de suppliers : {}", pageable);
		return ResponseEntity.ok(this.supplierService.findAll(pageable));
	}

	@GetMapping("{id}")
	@Timed
	public ResponseEntity<SupplierDto> findById(@PathVariable Long id) {
		log.debug("Recuperar supplier por id : {}", id);
		return ResponseEntity.ok(this.supplierService.findById(id));
	}

	@PostMapping
	@Timed
	public ResponseEntity<SupplierDto> save(@RequestBody SupplierDto supplierDto) {
		log.debug("Cadastrar um supplier : {}", supplierDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.supplierService.save(supplierDto));
	}

	@PutMapping("{id}")
	@Timed
	public ResponseEntity<SupplierDto> update(@PathVariable Long id, @RequestBody SupplierDto supplierDto) {
		log.debug("Alterar um supplier : {}", supplierDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.supplierService.update(id, supplierDto));
	}

	@DeleteMapping("{id}")
	@Timed
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		log.debug("Excluir um supplier : {}", id);
		this.supplierService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}