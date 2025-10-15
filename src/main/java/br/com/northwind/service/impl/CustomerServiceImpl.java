package br.com.northwind.service.impl;

import br.com.northwind.model.Customer;
import br.com.northwind.repository.CustomerRepository;
import br.com.northwind.service.CustomerService;
import br.com.northwind.service.dto.CustomerDto;
import br.com.northwind.service.mapper.CustomerMapper;
import br.com.northwind.service.projection.CustomerAndSuppliersByCityProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private  final CustomerMapper customerMapper;

    @Override
    public Page<CustomerAndSuppliersByCityProjection> customerAndSuppliersByCity(Pageable pageable) {
        return this.customerRepository.customerAndSuppliersByCity(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<CustomerDto> findAll(Pageable pageable) {
        return this.customerRepository.findAll(pageable).map(this.customerMapper::toDto);
    }

    private Customer findCustomerOrThrow(String id) {
        return this.customerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Customer %s not found.", id)));
    }

    @Transactional(readOnly = true)
    @Override
    public CustomerDto findById(String id) {
        return this.customerMapper.toDto(this.findCustomerOrThrow(id));
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return this.customerMapper.toDto(this.customerRepository.save(this.customerMapper.toEntity(customerDto)));
    }

    @Override
    public CustomerDto update(String id, CustomerDto customerDto) {
        Customer customer = this.findCustomerOrThrow(id);
        this.customerMapper.updateFromDto(customerDto, customer);
        return this.customerMapper.toDto(this.customerRepository.save(customer));
    }

    @Override
    public void deleteById(String id) {
        this.customerRepository.deleteById(id);
    }
}
