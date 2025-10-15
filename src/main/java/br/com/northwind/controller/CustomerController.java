package br.com.northwind.controller;

import br.com.northwind.service.CustomerService;
import br.com.northwind.service.dto.CustomerDto;
import br.com.northwind.service.projection.CustomerAndSuppliersByCityProjection;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
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

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("customer-and-suppliers-by-city")
    @Timed
    public ResponseEntity<Page<CustomerAndSuppliersByCityProjection>> customerAndSuppliersByCity(Pageable pageable) {
        return ResponseEntity.ok(this.customerService.customerAndSuppliersByCity(pageable));
    }

    @GetMapping
    @Timed
    public ResponseEntity<Page<CustomerDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(this.customerService.findAll(pageable));
    }

    @GetMapping("{id}")
    @Timed
    public ResponseEntity<CustomerDto> findById(@PathVariable String id) {
        return ResponseEntity.ok(this.customerService.findById(id));
    }

    @PostMapping
    @Timed
    public ResponseEntity<CustomerDto> save(@Valid @RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.customerService.save(customerDto));
    }

    @PutMapping("{id}")
    @Timed
    public ResponseEntity<CustomerDto> update(@PathVariable String id, @Valid @RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(this.customerService.update(id, customerDto));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Timed
    public void deleteById(@PathVariable String id) {
        this.customerService.deleteById(id);
    }
}