package br.com.northwind.repository;

import br.com.northwind.service.dto.CategoryProjection;
import br.com.northwind.service.dto.CategoryView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.northwind.model.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);

    List<CategoryProjection> findBy();

    List<CategoryView> findAllBy();
}