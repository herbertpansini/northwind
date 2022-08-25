package br.com.northwind.controller;

import br.com.northwind.service.dto.CurrentProductDto;
import br.com.northwind.service.dto.ProductAboveAveragePriceDto;
import br.com.northwind.service.dto.ProductByCategoryDto;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RestController;

import br.com.northwind.service.dto.ProductDto;
import br.com.northwind.service.ProductService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	private final Logger log = LoggerFactory.getLogger(ProductController.class);

	private final ProductService productService;

	@GetMapping
	@Timed
	public ResponseEntity<Page<ProductDto>> findAll(Pageable pageable) {
		log.debug("Recuperar uma coleção de produtos : {}", pageable);
		return ResponseEntity.ok(this.productService.findAll(pageable));
	}

	@GetMapping("{id}")
	@Timed
	public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
		log.debug("Recuperar uma produto : {}", id);
		return ResponseEntity.ok(this.productService.findById(id));
	}

	@GetMapping("/products-above-average-price")
	@Timed
	public ResponseEntity<Page<ProductAboveAveragePriceDto>> findProductsAboveAveragePrice(Pageable pageable) {
		log.debug("Recuperar uma coleção de produtos preço médio : {}", pageable);
		return ResponseEntity.ok(this.productService.findProductsAboveAveragePrice(pageable));
	}

	@GetMapping("/alphabetical-list-of-products")
	@Timed
	public ResponseEntity<Page<ProductDto>> findByDiscontinuedIsFalseOrderByName(Pageable pageable) {
		log.debug("Recuperar uma coleção de produtos por ordem alfabética : {}", pageable);
		return ResponseEntity.ok(this.productService.findByDiscontinuedIsFalseOrderByName(pageable));
	}

	@GetMapping("/current-products")
	@Timed
	public ResponseEntity<Page<CurrentProductDto>> findCurrentProducts(Pageable pageable) {
		log.debug("Recuperar uma coleção de produtos ativos : {}", pageable);
		return ResponseEntity.ok(this.productService.findCurrentProducts(pageable));
	}

	@GetMapping("/products-by-category")
	@Timed
	public ResponseEntity<Page<ProductByCategoryDto>> findProductsByCategory(Pageable pageable) {
		log.debug("Recuperar uma coleção de produtos por categoria : {}", pageable);
		return ResponseEntity.ok(this.productService.findProductsByCategory(pageable));
	}

	@PostMapping
	@Timed
	public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
		log.debug("Cadastrar um produto : {}", productDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.save(productDto));
	}

	@PutMapping("{id}")
	@Timed
	public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto productDto) {
		log.debug("Alterar um produto : {}", productDto);
		return ResponseEntity.ok(this.productService.update(id, productDto));
	}

	@DeleteMapping("{id}")
	@Timed
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		log.debug("Excluir um produto : {}", id);
		this.productService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}