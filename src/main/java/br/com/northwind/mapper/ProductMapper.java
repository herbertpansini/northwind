package br.com.northwind.mapper;

import br.com.northwind.dto.ProductDto;
import br.com.northwind.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, SupplierMapper.class})
public interface ProductMapper extends EntityMapper<ProductDto, Product> {
	
}