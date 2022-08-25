package br.com.northwind.service.impl;

import br.com.northwind.repository.EmployeeRepository;
import br.com.northwind.service.EmployeeService;
import br.com.northwind.service.dto.EmployeeDto;
import br.com.northwind.service.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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

    @Override
    public EmployeeDto findById(Long id) {
        return this.employeeMapper.toDto(this.employeeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Employee %d not found", id))));
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        return this.employeeMapper.toDto(this.employeeRepository.save(this.employeeMapper.toEntity(employeeDto)));
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto employeeDto) {
        EmployeeDto employeeUpdate = this.findById(id);
        BeanUtils.copyProperties(employeeDto, employeeUpdate, "id");
        return this.employeeMapper.toDto(this.employeeRepository.save(this.employeeMapper.toEntity(employeeUpdate)));
    }

    @Override
    public void deleteById(Long id) {
        this.employeeRepository.deleteById(id);
    }
}