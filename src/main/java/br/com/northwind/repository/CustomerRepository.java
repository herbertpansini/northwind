package br.com.northwind.repository;

import br.com.northwind.model.Customer;
import br.com.northwind.service.projection.CustomerAndSuppliersByCityProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "SELECT * FROM [Customer and Suppliers by city]", nativeQuery = true)
    Page<CustomerAndSuppliersByCityProjection> customerAndSuppliersByCity(Pageable pageable);
}