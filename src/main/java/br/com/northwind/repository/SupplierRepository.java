package br.com.northwind.repository;

import br.com.northwind.service.dto.SupplierByCityDto;
import br.com.northwind.service.dto.SupplierListItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.northwind.model.Supplier;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Page<SupplierByCityDto> findAllByOrderByCityAscCompanyNameAsc(Pageable pageable);

    List<SupplierListItemDto> findAllByOrderByCompanyName();
}