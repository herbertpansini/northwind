package br.com.northwind.repository;

import br.com.northwind.service.dto.SupplierByCityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.northwind.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Page<SupplierByCityDto> findByCompanyNameContainingIgnoreCaseOrderByCompanyName(String companyName, Pageable pageable);
}