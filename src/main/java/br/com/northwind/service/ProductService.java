package br.com.northwind.service;

import br.com.northwind.service.projection.AlphabeticalListOfProductsProjection;
import br.com.northwind.service.projection.CurrentProductListProjection;
import br.com.northwind.service.projection.ProductAboveAveragePriceProjection;
import br.com.northwind.service.projection.ProductByCategoryProjection;
import br.com.northwind.service.dto.ProductFilterDto;
import br.com.northwind.service.projection.ProductSalesFor1997Projection;
import br.com.northwind.service.projection.TenMostExpensiveProductsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.northwind.service.dto.ProductDto;

import java.util.List;

public interface ProductService {

    Page<ProductDto> findProductsByFilter(ProductFilterDto productFilterDto, Pageable pageable);

    ProductDto findById(long id);

    Page<ProductAboveAveragePriceProjection> findProductsAboveAveragePrice(Pageable pageable);

    Page<AlphabeticalListOfProductsProjection> findAlphabeticalListOfProducts(Pageable pageable);

    Page<CurrentProductListProjection> findCurrentProductList(Pageable pageable);

    Page<ProductByCategoryProjection> findProductsByCategory(Pageable pageable);

    Page<ProductSalesFor1997Projection> productSalesFor1997(Pageable pageable);

    List<TenMostExpensiveProductsProjection> tenMostExpensiveProducts();

    ProductDto save(ProductDto productDto);

    ProductDto update(long id, ProductDto productDto);

    void deleteById(long id);
}