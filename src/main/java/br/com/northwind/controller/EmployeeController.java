package br.com.northwind.controller;

import br.com.northwind.service.EmployeeService;
import br.com.northwind.service.dto.EmployeeDto;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    @Timed
    public ResponseEntity<Page<EmployeeDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(this.employeeService.findAll(pageable));
    }

    @GetMapping("{id}")
    @Timed
    public ResponseEntity<EmployeeDto> findById(@PathVariable long id) {
        return ResponseEntity.ok(this.employeeService.findById(id));
    }

    @PostMapping
    @Timed
    public ResponseEntity<EmployeeDto> save(@Valid @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.employeeService.save(employeeDto));
    }

    @PutMapping("{id}")
    @Timed
    public ResponseEntity<EmployeeDto> update(@PathVariable long id, @Valid @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(this.employeeService.update(id, employeeDto));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Timed
    public void deleteById(@PathVariable long id) {
        this.employeeService.deleteById(id);
    }
}