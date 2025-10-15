package br.com.northwind.repository;

import br.com.northwind.service.dto.CategoryListDto;
import br.com.northwind.service.dto.CategoryListItemDto;
import br.com.northwind.service.projection.CategorySalesFor1997Projection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.northwind.model.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT new br.com.northwind.service.dto.CategoryListDto( " +
            "c.id " +
            ",c.name " +
            ",c.description " +
            ") " +
           "FROM Category c " +
           "WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :term, '%')) " +
           "   OR LOWER(CAST(c.description AS string)) LIKE LOWER(CONCAT('%', :term, '%')) " +
           "ORDER BY c.name")
    Page<CategoryListDto> findByNameOrDescription(@Param("term") String term, Pageable pageable);

    List<CategoryListItemDto> findAllByOrderByName();

    @Query(value = "SELECT * FROM [Category Sales for 1997]", nativeQuery = true)
    Page<CategorySalesFor1997Projection> CategorySalesFor1997(Pageable pageable);
}