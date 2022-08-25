package br.com.northwind.service;

import br.com.northwind.service.dto.CategoryDto;
import br.com.northwind.service.dto.CategoryProjection;
import br.com.northwind.service.dto.CategoryView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

   Page<CategoryDto> findAll(Pageable pageable);

   Page<CategoryDto> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);

   List<CategoryProjection> findBy();

   List<CategoryView> findAllBy();
   
   CategoryDto findById(Long id);
   
   CategoryDto save(CategoryDto categoryDto);
   
   CategoryDto update(Long id, CategoryDto categoryDto);
   
   void deleteById(Long id);
}