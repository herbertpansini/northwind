package br.com.northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.northwind.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}