package br.com.northwind.controller;

import java.util.List;

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

import br.com.northwind.dto.CategoryDto;
import br.com.northwind.service.CategoryService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
		
	private final CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> findAll() {
		List<CategoryDto> categories = this.categoryService.findAll();
		return ResponseEntity.ok(categories);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
		CategoryDto category = this.categoryService.findById(id);
		return category != null ? ResponseEntity.ok(category) : ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto) {
		CategoryDto categorySave = this.categoryService.save(categoryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(categorySave);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto, @PathVariable Long id) {
		CategoryDto categoryUpdate = this.categoryService.update(categoryDto, id);
		return ResponseEntity.ok(categoryUpdate);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		this.categoryService.delete(id);
	}
}