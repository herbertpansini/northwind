package br.com.northwind.service.impl;

import br.com.northwind.model.Product;
import br.com.northwind.service.ProductService;
import br.com.northwind.service.projection.AlphabeticalListOfProductsProjection;
import br.com.northwind.service.projection.CurrentProductListProjection;
import br.com.northwind.service.projection.ProductAboveAveragePriceProjection;
import br.com.northwind.service.projection.ProductByCategoryProjection;
import br.com.northwind.service.dto.ProductFilterDto;
import br.com.northwind.service.projection.ProductSalesFor1997Projection;
import br.com.northwind.service.projection.TenMostExpensiveProductsProjection;
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

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional(readOnly = true)
    @Override
    public Page<ProductDto> findProductsByFilter(ProductFilterDto productFilterDto, Pageable pageable) {
    	return this.productRepository.findProductsByFilter(productFilterDto, pageable).map(this.productMapper::toDto);
    }

    private Product findProductOrThrow(long id) {
        return this.productRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product %d not found.", id)));
    }

    @Transactional(readOnly = true)
    @Override
    public ProductDto findById(long id) {
        return this.productMapper.toDto(this.findProductOrThrow(id));
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ProductAboveAveragePriceProjection> findProductsAboveAveragePrice(Pageable pageable) {
        return this.productRepository.findProductsAboveAveragePrice(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<AlphabeticalListOfProductsProjection> findAlphabeticalListOfProducts(Pageable pageable) {
        return this.productRepository.findAlphabeticalListOfProducts(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<CurrentProductListProjection> findCurrentProductList(Pageable pageable) {
        return this.productRepository.findCurrentProductList(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ProductByCategoryProjection> findProductsByCategory(Pageable pageable) {
        return this.productRepository.findProductsByCategory(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ProductSalesFor1997Projection> productSalesFor1997(Pageable pageable) {
        return this.productRepository.productSalesFor1997(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TenMostExpensiveProductsProjection> tenMostExpensiveProducts() {
        return this.productRepository.tenMostExpensiveProducts();
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return this.productMapper.toDto(this.productRepository.save(this.productMapper.toEntity(productDto)));
    }

    @Override
    public ProductDto update(long id, ProductDto productDto) {
        Product product = this.findProductOrThrow(id);
        this.productMapper.updateEntityFromDto(productDto, product);
        return this.productMapper.toDto(this.productRepository.save(product));
    }

    @Override
    public void deleteById(long id) {
        this.productRepository.deleteById(id);
    }
}