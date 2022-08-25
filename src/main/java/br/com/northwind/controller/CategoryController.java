package br.com.northwind.controller;

import br.com.northwind.service.dto.CategoryProjection;
import br.com.northwind.service.dto.CategoryView;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.northwind.service.dto.CategoryDto;
import br.com.northwind.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

	private final Logger log = LoggerFactory.getLogger(CategoryController.class);
		
	private final CategoryService categoryService;
	
	@GetMapping
	@Timed
	public ResponseEntity<Page<CategoryDto>> findAll(Pageable pageable) {
		log.debug("Recuperar uma coleção de categorias : {}", pageable);
		return ResponseEntity.ok(this.categoryService.findAll(pageable));
	}

	@GetMapping("/by-name-or-description")
	@Timed
	public ResponseEntity<Page<CategoryDto>> findByNameContainingIgnoreCaseOrderByName(@RequestParam(value = "name", required = false, defaultValue = "") String name, Pageable pageable) {
		log.debug("Recuperar categorias por nome : {}", name);
		return ResponseEntity.ok(this.categoryService.findByNameContainingIgnoreCaseOrderByName(name, pageable));
	}

	@GetMapping("/all")
	@Timed
	public ResponseEntity<List<CategoryProjection>> findBy() {
		log.debug("Recuperar categorias");
		return ResponseEntity.ok(this.categoryService.findBy());
	}

	@GetMapping("/all-by")
	@Timed
	public ResponseEntity<List<CategoryView>> findAllBy() {
		log.debug("Recuperar categorias");
		return ResponseEntity.ok(this.categoryService.findAllBy());
	}
	
	@GetMapping("{id}")
	@Timed
	public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
		log.debug("Recuperar uma categoria : {}", id);
		return ResponseEntity.ok(this.categoryService.findById(id));
	}
	
	@PostMapping
	@Timed
	public ResponseEntity<CategoryDto> save(@Valid @RequestBody CategoryDto categoryDto) {
		log.debug("Cadastrar uma categoria : {}", categoryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.categoryService.save(categoryDto));
	}
	
	@PutMapping("{id}")
	@Timed
	public ResponseEntity<CategoryDto> update(@PathVariable Long id, @Valid @RequestBody CategoryDto categoryDto) {
		log.debug("Alterar uma categoria : {}", categoryDto);
		return ResponseEntity.ok(this.categoryService.update(id, categoryDto));
	}
	
	@DeleteMapping("{id}")
	@Timed
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		log.debug("Excluir uma categoria : {}", id);
		this.categoryService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}