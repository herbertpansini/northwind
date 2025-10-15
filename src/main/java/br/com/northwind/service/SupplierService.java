package br.com.northwind.service;

import br.com.northwind.service.dto.SupplierByCityDto;
import br.com.northwind.service.dto.SupplierDto;
import br.com.northwind.service.dto.SupplierListItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SupplierService {
	Page<SupplierByCityDto> findSuppliersByCity(Pageable pageable);

	Page<SupplierDto> findAll(Pageable pageable);

	SupplierDto findById(long id);

    List<SupplierListItemDto> findAllByOrderByCompanyName();

	SupplierDto save(SupplierDto supplierDto);

	SupplierDto update(long id, SupplierDto supplierDto);

	void deleteById(long id);
}