package br.com.northwind.service;

import br.com.northwind.service.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Page<EmployeeDto> findAll(Pageable pageable);

    EmployeeDto findById(Long id);

    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto update(Long id, EmployeeDto employeeDto);

    void deleteById(Long id);
}