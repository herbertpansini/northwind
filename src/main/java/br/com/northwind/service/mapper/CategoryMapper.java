package br.com.northwind.service.mapper;

import br.com.northwind.service.dto.CategoryDto;
import br.com.northwind.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDto, Category> {
}