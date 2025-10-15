package br.com.northwind.service;

import br.com.northwind.service.dto.CategoryDto;
import br.com.northwind.service.dto.CategoryListDto;
import br.com.northwind.service.dto.CategoryListItemDto;
import br.com.northwind.service.projection.CategorySalesFor1997Projection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
   Page<CategoryListDto> findByNameOrDescription(String term, Pageable pageable);

    List<CategoryListItemDto> findAllByOrderByName();

    Page<CategorySalesFor1997Projection> categorySalesFor1997(Pageable pageable);

   CategoryDto findById(long id);
   
   CategoryDto save(CategoryDto categoryDto);
   
   CategoryDto update(long id, CategoryDto categoryDto);
   
   void deleteById(long id);
}