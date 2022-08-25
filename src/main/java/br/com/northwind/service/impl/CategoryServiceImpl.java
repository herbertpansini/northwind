package br.com.northwind.service.impl;

import br.com.northwind.service.CategoryService;
import br.com.northwind.service.dto.CategoryProjection;
import br.com.northwind.service.dto.CategoryView;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.northwind.service.dto.CategoryDto;
import br.com.northwind.service.mapper.CategoryMapper;
import br.com.northwind.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

	@Transactional(readOnly = true)
    @Override
    public Page<CategoryDto> findAll(Pageable pageable) {
        return this.categoryRepository.findAll(pageable).map(this.categoryMapper::toDto);
    }

	@Transactional(readOnly = true)
	@Override
	public Page<CategoryDto> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable) {
		return this.categoryRepository.findByNameContainingIgnoreCaseOrderByName(name, pageable).map(this.categoryMapper::toDto);
	}

	@Transactional(readOnly = true)
	@Override
	public List<CategoryProjection> findBy() {
		return this.categoryRepository.findBy();
	}

	@Transactional(readOnly = true)
	@Override
	public List<CategoryView> findAllBy() {
		return this.categoryRepository.findAllBy();
	}

	@Transactional(readOnly = true)
    @Override
	public CategoryDto findById(Long id) {		
		return this.categoryMapper.toDto(this.categoryRepository.findById(id).orElseThrow(() ->
				new ResponseStatusException(HttpStatus.NO_CONTENT, String.format("Category %d not found.", id))));
	}

	@Override
	public CategoryDto save(CategoryDto categoryDto) {
		return this.categoryMapper.toDto(this.categoryRepository.save(this.categoryMapper.toEntity(categoryDto)));
	}

	@Override
	public CategoryDto update(Long id, CategoryDto categoryDto) {
		CategoryDto categoryUpdate = this.findById(id);
		BeanUtils.copyProperties(categoryDto, categoryUpdate, "id");
		return this.categoryMapper.toDto(this.categoryRepository.save(this.categoryMapper.toEntity(categoryUpdate)));
	}

	@Override
	public void deleteById(Long id) {
		this.categoryRepository.deleteById(id);		
	}
}