package br.com.northwind.repository;

import br.com.northwind.model.Order;
import br.com.northwind.service.projection.EmployeeSalesByCountryProjection;
import br.com.northwind.service.projection.SalesByYearProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @EntityGraph(attributePaths = {"customer", "employee", "orderDetails"})
    @Query("SELECT o FROM Order o")
    Page<Order> findAll(Pageable pageable);

    @Query(value = "EXEC [Employee Sales by Country] :beginningDate, :endingDate", nativeQuery = true)
    List<EmployeeSalesByCountryProjection> findEmployeeSalesByCountry(@Param("beginningDate") LocalDateTime beginningDate, @Param("endingDate") LocalDateTime endingDate);

    @Query(value = "EXEC [Sales by Year] :beginningDate, :endingDate", nativeQuery = true)
    List<SalesByYearProjection> findSalesByYear(@Param("beginningDate") LocalDateTime beginningDate, @Param("endingDate") LocalDateTime endingDate);
}