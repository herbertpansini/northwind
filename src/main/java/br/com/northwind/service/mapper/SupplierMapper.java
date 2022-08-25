package br.com.northwind.service.mapper;

import org.mapstruct.Mapper;

import br.com.northwind.service.dto.SupplierDto;
import br.com.northwind.model.Supplier;

@Mapper(componentModel = "spring")
public interface SupplierMapper extends EntityMapper<SupplierDto, Supplier> {

}
