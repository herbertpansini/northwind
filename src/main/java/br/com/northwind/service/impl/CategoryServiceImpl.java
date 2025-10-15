package br.com.northwind.service.impl;

import br.com.northwind.service.CategoryService;
import br.com.northwind.service.dto.CategoryListDto;
import br.com.northwind.service.dto.CategoryListItemDto;
import br.com.northwind.service.projection.CategorySalesFor1997Projection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.northwind.service.dto.CategoryDto;
import br.com.northwind.service.mapper.CategoryMapper;
import br.com.northwind.model.Category;
import br.com.northwind.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryServiceImpl implements CategoryService {
    final CategoryRepository categoryRepository;
    final CategoryMapper categoryMapper;

    @Transactional(readOnly = true)
    @Override
    public Page<CategoryListDto> findByNameOrDescription(String term, Pageable pageable) {
        return this.categoryRepository.findByNameOrDescription(term, pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CategoryListItemDto> findAllByOrderByName() {
        return this.categoryRepository.findAllByOrderByName();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<CategorySalesFor1997Projection> categorySalesFor1997(Pageable pageable) {
        return this.categoryRepository.CategorySalesFor1997(pageable);
    }

    private Category findCategoryOrThrow(long id) {
        return this.categoryRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Category %d not found.", id)));
	}

    @Transactional(readOnly = true)
    @Override
	public CategoryDto findById(long id) {
		return this.categoryMapper.toDto(this.findCategoryOrThrow(id));
	}

	@Override
	public CategoryDto save(CategoryDto categoryDto) {
		return this.categoryMapper.toDto(this.categoryRepository.save(this.categoryMapper.toEntity(categoryDto)));
	}

	@Override
	public CategoryDto update(long id, CategoryDto categoryDto) {
		Category category = this.findCategoryOrThrow(id);
		this.categoryMapper.updateEntityFromDto(categoryDto, category);
		return this.categoryMapper.toDto(this.categoryRepository.save(category));
	}

	@Override
	public void deleteById(long id) {
		this.categoryRepository.deleteById(id);
	}
}