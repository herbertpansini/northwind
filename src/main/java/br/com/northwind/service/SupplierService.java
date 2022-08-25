package br.com.northwind.service;

import br.com.northwind.service.dto.SupplierByCityDto;
import br.com.northwind.service.dto.SupplierDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SupplierService {
	Page<SupplierByCityDto> findByCompanyNameContainingIgnoreCaseOrderByCompanyName(String companyName, Pageable pageable);
	
	Page<SupplierDto> findAll(Pageable pageable);

	SupplierDto findById(Long id);

	SupplierDto save(SupplierDto supplierDto);

	SupplierDto update(Long id, SupplierDto supplierDto);

	void deleteById(Long id);
}
