package br.com.northwind.controller;

import br.com.northwind.service.dto.SupplierByCityDto;
import br.com.northwind.service.dto.SupplierDto;
import br.com.northwind.service.dto.SupplierListItemDto;
import io.micrometer.core.annotation.Timed;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.northwind.service.SupplierService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {
	private final SupplierService supplierService;

	@GetMapping("/by-city")
	@Timed
	public ResponseEntity<Page<SupplierByCityDto>> findSuppliersByCity(Pageable pageable) {
		return ResponseEntity.ok(this.supplierService.findSuppliersByCity(pageable));
	}
	
	@GetMapping
	@Timed
	public ResponseEntity<Page<SupplierDto>> findAll(Pageable pageable) {
		return ResponseEntity.ok(this.supplierService.findAll(pageable));
	}

	@GetMapping("{id}")
	@Timed
	public ResponseEntity<SupplierDto> findById(@PathVariable long id) {
		return ResponseEntity.ok(this.supplierService.findById(id));
	}

    @GetMapping("/list-item")
    @Timed
    public ResponseEntity<List<SupplierListItemDto>> findAllByOrderByCompanyName() {
        return ResponseEntity.ok(this.supplierService.findAllByOrderByCompanyName());
    }

	@PostMapping
	@Timed
	public ResponseEntity<SupplierDto> save(@RequestBody SupplierDto supplierDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.supplierService.save(supplierDto));
	}

	@PutMapping("{id}")
	@Timed
	public ResponseEntity<SupplierDto> update(@PathVariable long id, @RequestBody SupplierDto supplierDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.supplierService.update(id, supplierDto));
	}

	@DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	@Timed
	public void deleteById(@PathVariable long id) {
		this.supplierService.deleteById(id);
	}
}