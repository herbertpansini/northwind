package br.com.northwind.service.impl;

import br.com.northwind.model.Supplier;
import br.com.northwind.service.SupplierService;
import br.com.northwind.service.dto.SupplierByCityDto;
import br.com.northwind.service.dto.SupplierDto;
import br.com.northwind.service.dto.SupplierListItemDto;
import br.com.northwind.service.mapper.SupplierMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.northwind.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
	
	private final SupplierRepository supplierRepository;
	private final SupplierMapper supplierMapper;

	@Transactional(readOnly = true)
	@Override
	public Page<SupplierDto> findAll(Pageable pageable) {
		return this.supplierRepository.findAll(pageable).map(this.supplierMapper::toDto);
	}

    private Supplier findSupplierOrThrow(long id) {
        return this.supplierRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Supplier %d not found.", id)));
    }

	@Transactional(readOnly = true)
	@Override
	public SupplierDto findById(long id) {
		return this.supplierMapper.toDto(this.findSupplierOrThrow(id));
	}

    @Transactional(readOnly = true)
    @Override
    public Page<SupplierByCityDto> findSuppliersByCity(Pageable pageable) {
        return this.supplierRepository.findAllByOrderByCityAscCompanyNameAsc(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SupplierListItemDto> findAllByOrderByCompanyName() {
        return this.supplierRepository.findAllByOrderByCompanyName();
    }

    @Override
	public SupplierDto save(SupplierDto supplierDto) {
		return this.supplierMapper.toDto(this.supplierRepository.save(this.supplierMapper.toEntity(supplierDto)));
	}

	@Override
	public SupplierDto update(long id, SupplierDto supplierDto) {
		Supplier supplier = this.findSupplierOrThrow(id);
		this.supplierMapper.updateEntityFromDto(supplierDto, supplier);
		return this.supplierMapper.toDto(this.supplierRepository.save(supplier));
	}

	@Override
	public void deleteById(long id) {
		this.supplierRepository.deleteById(id);
	}
}