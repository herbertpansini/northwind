package br.com.northwind.controller;

import br.com.northwind.service.projection.AlphabeticalListOfProductsProjection;
import br.com.northwind.service.projection.CurrentProductListProjection;
import br.com.northwind.service.projection.ProductAboveAveragePriceProjection;
import br.com.northwind.service.projection.ProductByCategoryProjection;
import br.com.northwind.service.dto.ProductFilterDto;
import br.com.northwind.service.projection.ProductSalesFor1997Projection;
import br.com.northwind.service.projection.TenMostExpensiveProductsProjection;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.northwind.service.dto.ProductDto;
import br.com.northwind.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@GetMapping
	@Timed
	public ResponseEntity<Page<ProductDto>> findProductsByFilter(ProductFilterDto productFilterDto, Pageable pageable) {
		return ResponseEntity.ok(this.productService.findProductsByFilter(productFilterDto, pageable));
	}

	@GetMapping("{id}")
	@Timed
	public ResponseEntity<ProductDto> findById(@PathVariable long id) {
		return ResponseEntity.ok(this.productService.findById(id));
	}

	@GetMapping("/products-above-average-price")
	@Timed
	public ResponseEntity<Page<ProductAboveAveragePriceProjection>> findProductsAboveAveragePrice(Pageable pageable) {
		return ResponseEntity.ok(this.productService.findProductsAboveAveragePrice(pageable));
	}

	@GetMapping("/alphabetical-list-of-products")
	@Timed
	public ResponseEntity<Page<AlphabeticalListOfProductsProjection>> findAlphabeticalListOfProducts(Pageable pageable) {
		return ResponseEntity.ok(this.productService.findAlphabeticalListOfProducts(pageable));
	}

	@GetMapping("/current-product-list")
	@Timed
	public ResponseEntity<Page<CurrentProductListProjection>> findCurrentProductList(Pageable pageable) {
		return ResponseEntity.ok(this.productService.findCurrentProductList(pageable));
	}

	@GetMapping("/products-by-category")
	@Timed
	public ResponseEntity<Page<ProductByCategoryProjection>> findProductsByCategory(Pageable pageable) {
		return ResponseEntity.ok(this.productService.findProductsByCategory(pageable));
	}

    @GetMapping("/product-sales-for-1997")
    @Timed
    public ResponseEntity<Page<ProductSalesFor1997Projection>> productSalesFor1997(Pageable pageable) {
        return ResponseEntity.ok(this.productService.productSalesFor1997(pageable));
    }

    @GetMapping("/ten-most-expensive-products")
    @Timed
    public ResponseEntity<List<TenMostExpensiveProductsProjection>> tenMostExpensiveProducts() {
        return ResponseEntity.ok(this.productService.tenMostExpensiveProducts());
    }

	@PostMapping
	@Timed
	public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.save(productDto));
	}

	@PutMapping("{id}")
	@Timed
	public ResponseEntity<ProductDto> update(@PathVariable long id, @RequestBody ProductDto productDto) {
		return ResponseEntity.ok(this.productService.update(id, productDto));
	}

	@DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	@Timed
	public void deleteById(@PathVariable long id) {
		this.productService.deleteById(id);
	}
}