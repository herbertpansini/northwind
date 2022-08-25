package br.com.northwind.repository;

import br.com.northwind.service.dto.CurrentProductDto;
import br.com.northwind.service.dto.ProductAboveAveragePriceDto;
import br.com.northwind.service.dto.ProductByCategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.northwind.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new br.com.northwind.service.dto.ProductAboveAveragePriceDto( " +
            "p.name, " +
            "p.unitPrice) " +
            "FROM Product p " +
            "WHERE p.unitPrice > (SELECT AVG(p.unitPrice) From Product p)")
    Page<ProductAboveAveragePriceDto> findProductsAboveAveragePrice(Pageable pageable);

    Page<Product> findByDiscontinuedIsFalseOrderByName(Pageable pageable);

    @Query("SELECT new br.com.northwind.service.dto.CurrentProductDto( " +
            "p.id, " +
            "p.name) " +
            "FROM Product p " +
            "WHERE (((p.discontinued)=false)) " +
            "ORDER BY p.name")
    Page<CurrentProductDto> findCurrentProducts(Pageable pageable);

    @Query("SELECT new br.com.northwind.service.dto.ProductByCategoryDto( " +
            "c.name, " +
            "p.name, " +
            "p.quantityPerUnit, " +
            "p.unitsInStock, " +
            "p.discontinued) " +
            "FROM Product p " +
            "INNER JOIN p.category c " +
            "WHERE p.discontinued <> true " +
            "ORDER BY c.name, p.name")
    Page<ProductByCategoryDto> findProductsByCategory(Pageable pageable);
}