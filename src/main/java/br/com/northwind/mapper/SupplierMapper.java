package br.com.northwind.mapper;

import org.mapstruct.Mapper;

import br.com.northwind.dto.SupplierDto;
import br.com.northwind.model.Supplier;

@Mapper(componentModel = "spring")
public interface SupplierMapper extends EntityMapper<SupplierDto, Supplier> {

}
