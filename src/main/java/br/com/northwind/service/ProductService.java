package br.com.northwind.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.northwind.dto.ProductDto;

public interface ProductService {

    Page<ProductDto> findAll(Pageable pageable);    
}