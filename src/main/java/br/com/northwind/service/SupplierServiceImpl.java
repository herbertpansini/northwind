package br.com.northwind.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.northwind.model.Supplier;
import br.com.northwind.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
	
	private final SupplierRepository supplierRepository;
	
	@Override
	public Page<Supplier> findAll(Pageable pageable) {
		return this.supplierRepository.findAll(pageable);
	}
}