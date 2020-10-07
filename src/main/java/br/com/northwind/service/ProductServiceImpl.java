package br.com.northwind.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.northwind.dto.ProductDto;
import br.com.northwind.mapper.ProductMapper;
import br.com.northwind.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Page<ProductDto> findAll(Pageable pageable) {
    	return this.productRepository.findAll(pageable).map(this.productMapper::toDto);
    }
}