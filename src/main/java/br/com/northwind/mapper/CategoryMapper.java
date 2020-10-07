package br.com.northwind.mapper;

import br.com.northwind.dto.CategoryDto;
import br.com.northwind.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDto, Category> {
}