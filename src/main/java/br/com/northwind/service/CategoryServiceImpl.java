package br.com.northwind.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.northwind.dto.CategoryDto;
import br.com.northwind.mapper.CategoryMapper;
import br.com.northwind.model.Category;
import br.com.northwind.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> findAll() {
        return this.categoryMapper.toDto( this.categoryRepository.findAll() );
    }
    
    @Override
	public CategoryDto findById(Long id) {		
		return this.categoryMapper.toDto( this.categoryRepository.findById(id).orElse(null) );
	}

	@Override
	public CategoryDto save(CategoryDto categoryDto) {
		Category category = this.categoryMapper.toEntity(categoryDto);
		return this.categoryMapper.toDto( this.categoryRepository.save(category) );
	}

	@Override
	public CategoryDto update(CategoryDto categoryDto, Long id) {
		Category categoryUpdate = this.categoryMapper.toEntity( this.findById(id) );
		Category category = this.categoryMapper.toEntity(categoryDto);
		BeanUtils.copyProperties(category, categoryUpdate, "id");
		return this.categoryMapper.toDto( this.categoryRepository.save(categoryUpdate) );
	}

	@Override
	public void delete(Long id) {
		this.categoryRepository.deleteById(id);		
	}
}
