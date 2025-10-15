package br.com.northwind.service.impl;

import br.com.northwind.model.Employee;
import br.com.northwind.repository.EmployeeRepository;
import br.com.northwind.service.EmployeeService;
import br.com.northwind.service.dto.EmployeeDto;
import br.com.northwind.service.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public Page<EmployeeDto> findAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable).map(this.employeeMapper::toDto);
    }

    private Employee findEmployeeOrThrow(Long id) {
        return this.employeeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Employee %d not found.", id)));
    }

    @Override
    public EmployeeDto findById(long id) {
        return this.employeeMapper.toDto(this.findEmployeeOrThrow(id));
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        return this.employeeMapper.toDto(this.employeeRepository.save(this.employeeMapper.toEntity(employeeDto)));
    }

    @Override
    public EmployeeDto update(long id, EmployeeDto employeeDto) {
        Employee employee = this.findEmployeeOrThrow(id);
        this.employeeMapper.updateEntityFromDto(employeeDto, employee);
        return this.employeeMapper.toDto(this.employeeRepository.save(employee));
    }

    @Override
    public void deleteById(long id) {
        this.employeeRepository.deleteById(id);
    }
}