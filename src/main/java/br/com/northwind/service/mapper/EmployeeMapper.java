package br.com.northwind.service.mapper;

import br.com.northwind.model.Employee;
import br.com.northwind.service.dto.EmployeeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDto, Employee> {
}