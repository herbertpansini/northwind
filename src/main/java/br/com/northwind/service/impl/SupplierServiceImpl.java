package br.com.northwind.service.impl;

import br.com.northwind.service.SupplierService;
import br.com.northwind.service.dto.SupplierByCityDto;
import br.com.northwind.service.dto.SupplierDto;
import br.com.northwind.service.mapper.SupplierMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.northwind.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
	
	private final SupplierRepository supplierRepository;
	private final SupplierMapper supplierMapper;

	@Transactional(readOnly = true)
	@Override
	public Page<SupplierByCityDto> findByCompanyNameContainingIgnoreCaseOrderByCompanyName(String companyName, Pageable pageable) {
		return this.supplierRepository.findByCompanyNameContainingIgnoreCaseOrderByCompanyName(companyName, pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<SupplierDto> findAll(Pageable pageable) {
		return this.supplierRepository.findAll(pageable).map(this.supplierMapper::toDto);
	}

	@Transactional(readOnly = true)
	@Override
	public SupplierDto findById(Long id) {
		return this.supplierMapper.toDto(this.supplierRepository.findById(id).orElseThrow(()->
				new ResponseStatusException(HttpStatus.NO_CONTENT, String.format("Supplier %d not found.", id))));
	}

	@Override
	public SupplierDto save(SupplierDto supplierDto) {
		return this.supplierMapper.toDto(this.supplierRepository.save(this.supplierMapper.toEntity(supplierDto)));
	}

	@Override
	public SupplierDto update(Long id, SupplierDto supplierDto) {
		SupplierDto supplierUpdate = this.findById(id);
		BeanUtils.copyProperties(supplierDto, supplierUpdate, "id");
		return this.supplierMapper.toDto(this.supplierRepository.save(this.supplierMapper.toEntity(supplierUpdate)));
	}

	@Override
	public void deleteById(Long id) {
		this.supplierRepository.deleteById(id);
	}
}