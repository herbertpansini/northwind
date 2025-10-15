package br.com.northwind.repository;

import br.com.northwind.service.projection.AlphabeticalListOfProductsProjection;
import br.com.northwind.service.projection.CurrentProductListProjection;
import br.com.northwind.service.projection.ProductAboveAveragePriceProjection;
import br.com.northwind.service.projection.ProductByCategoryProjection;
import br.com.northwind.service.dto.ProductFilterDto;
import br.com.northwind.service.projection.ProductSalesFor1997Projection;
import br.com.northwind.service.projection.TenMostExpensiveProductsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.northwind.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p " +
           "FROM Product p " +
           "WHERE (:#{#filter.name} IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', CAST(:#{#filter.name} AS string), '%')) ) " +
           "  AND (:#{#filter.categoryId} IS NULL OR p.category.id = :#{#filter.categoryId}) " +
           "  AND (:#{#filter.supplierId} IS NULL OR p.supplier.id = :#{#filter.supplierId}) ")
    Page<Product> findProductsByFilter(@Param("filter") ProductFilterDto productFilterDto, Pageable pageable);

    @Query(value = "SELECT * FROM [products above average price]", nativeQuery = true)
    Page<ProductAboveAveragePriceProjection> findProductsAboveAveragePrice(Pageable pageable);

    @Query(value = "SELECT * FROM [Alphabetical list of products]", nativeQuery = true)
    Page<AlphabeticalListOfProductsProjection> findAlphabeticalListOfProducts(Pageable pageable);

    @Query(value = "SELECT * FROM [Current Product List]", nativeQuery = true)
    Page<CurrentProductListProjection> findCurrentProductList(Pageable pageable);

    @Query(value = "SELECT * FROM [products by category]", nativeQuery = true)
    Page<ProductByCategoryProjection> findProductsByCategory(Pageable pageable);

    @Query(value = "SELECT * FROM [Product Sales for 1997]", nativeQuery = true)
    Page<ProductSalesFor1997Projection> productSalesFor1997(Pageable pageable);

    @Query(value = "EXEC [Ten Most Expensive Products]", nativeQuery = true)
    List<TenMostExpensiveProductsProjection> tenMostExpensiveProducts();
}