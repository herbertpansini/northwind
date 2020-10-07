package br.com.northwind.service;

import java.util.List;

import br.com.northwind.dto.CategoryDto;

public interface CategoryService {

   List<CategoryDto> findAll();
   
   CategoryDto findById(Long id);
   
   CategoryDto save(CategoryDto categoryDto);
   
   CategoryDto update(CategoryDto categoryDto, Long id);
   
   void delete(Long id);
}