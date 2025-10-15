package br.com.northwind.controller;

import br.com.northwind.service.dto.CategoryListDto;
import br.com.northwind.service.dto.CategoryListItemDto;
import br.com.northwind.service.projection.CategorySalesFor1997Projection;
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

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService categoryService;
	
	@GetMapping("/search")
	@Timed
	public ResponseEntity<Page<CategoryListDto>> findByNameOrDescription(@RequestParam(value = "term", required = false, defaultValue = "") String term, Pageable pageable) {
		return ResponseEntity.ok(this.categoryService.findByNameOrDescription(term, pageable));
	}

    @GetMapping
    @Timed
    public ResponseEntity<List<CategoryListItemDto>> findAllByOrderByName() {
        return ResponseEntity.ok(this.categoryService.findAllByOrderByName());
    }

    @GetMapping("/category-sales-for-1997")
    @Timed
    public ResponseEntity<Page<CategorySalesFor1997Projection>> categorySalesFor1997(Pageable pageable) {
        return ResponseEntity.ok(this.categoryService.categorySalesFor1997(pageable));
    }
	
	@GetMapping("{id}")
	@Timed
	public ResponseEntity<CategoryDto> findById(@PathVariable long id) {
		return ResponseEntity.ok(this.categoryService.findById(id));
	}
	
	@PostMapping
	@Timed
	public ResponseEntity<CategoryDto> save(@Valid @RequestBody CategoryDto categoryDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.categoryService.save(categoryDto));
	}
	
	@PutMapping("{id}")
	@Timed
	public ResponseEntity<CategoryDto> update(@PathVariable long id, @Valid @RequestBody CategoryDto categoryDto) {
		return ResponseEntity.ok(this.categoryService.update(id, categoryDto));
	}
	
	@DeleteMapping("{id}")
	@Timed
	public ResponseEntity<Void> deleteById(@PathVariable long id) {
		this.categoryService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}