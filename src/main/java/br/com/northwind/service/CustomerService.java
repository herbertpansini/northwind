package br.com.northwind.service;

import br.com.northwind.service.dto.CustomerDto;
import br.com.northwind.service.projection.CustomerAndSuppliersByCityProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<CustomerAndSuppliersByCityProjection> customerAndSuppliersByCity(Pageable pageable);

    Page<CustomerDto> findAll(Pageable pageable);

    CustomerDto findById(String id);

    CustomerDto save(CustomerDto customerDto);

    CustomerDto update(String id, CustomerDto customerDto);

    void deleteById(String id);
}