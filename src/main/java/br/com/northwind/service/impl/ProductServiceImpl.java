package br.com.northwind.service.impl;

import br.com.northwind.service.ProductService;
import br.com.northwind.service.dto.CurrentProductDto;
import br.com.northwind.service.dto.ProductAboveAveragePriceDto;
import br.com.northwind.service.dto.ProductByCategoryDto;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.northwind.service.dto.ProductDto;
import br.com.northwind.service.mapper.ProductMapper;
import br.com.northwind.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional(readOnly = true)
    @Override
    public Page<ProductDto> findAll(Pageable pageable) {
    	return this.productRepository.findAll(pageable).map(this.productMapper::toDto);
    }

    @Transactional(readOnly = true)
    @Override
    public ProductDto findById(Long id) {
        return this.productMapper.toDto(this.productRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT, String.format("Product %d not found.", id))));
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ProductAboveAveragePriceDto> findProductsAboveAveragePrice(Pageable pageable) {
        return this.productRepository.findProductsAboveAveragePrice(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ProductDto> findByDiscontinuedIsFalseOrderByName(Pageable pageable) {
        return this.productRepository.findByDiscontinuedIsFalseOrderByName(pageable).map(this.productMapper::toDto);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<CurrentProductDto> findCurrentProducts(Pageable pageable) {
        return this.productRepository.findCurrentProducts(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ProductByCategoryDto> findProductsByCategory(Pageable pageable) {
        return this.productRepository.findProductsByCategory(pageable);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return this.productMapper.toDto(this.productRepository.save(this.productMapper.toEntity(productDto)));
    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        ProductDto productUpdate = this.findById(id);
        BeanUtils.copyProperties(productDto, productUpdate, "id");
        return this.productMapper.toDto(this.productRepository.save(this.productMapper.toEntity(productUpdate)));
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}