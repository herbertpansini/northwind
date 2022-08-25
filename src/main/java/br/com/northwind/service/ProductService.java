package br.com.northwind.service;

import br.com.northwind.service.dto.CurrentProductDto;
import br.com.northwind.service.dto.ProductAboveAveragePriceDto;
import br.com.northwind.service.dto.ProductByCategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.northwind.service.dto.ProductDto;

public interface ProductService {

    Page<ProductDto> findAll(Pageable pageable);

    ProductDto findById(Long id);

    Page<ProductAboveAveragePriceDto> findProductsAboveAveragePrice(Pageable pageable);

    Page<ProductDto> findByDiscontinuedIsFalseOrderByName(Pageable pageable);

    Page<CurrentProductDto> findCurrentProducts(Pageable pageable);

    Page<ProductByCategoryDto> findProductsByCategory(Pageable pageable);

    ProductDto save(ProductDto productDto);

    ProductDto update(Long id, ProductDto productDto);

    void deleteById(Long id);
}