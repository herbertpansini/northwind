package br.com.northwind.service;

import br.com.northwind.service.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Page<EmployeeDto> findAll(Pageable pageable);

    EmployeeDto findById(long id);

    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto update(long id, EmployeeDto employeeDto);

    void deleteById(long id);
}