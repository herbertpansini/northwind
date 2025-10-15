package br.com.northwind.service;

import br.com.northwind.service.dto.OrderDto;
import br.com.northwind.service.projection.EmployeeSalesByCountryProjection;
import br.com.northwind.service.projection.SalesByYearProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface OrderService {
    Page<OrderDto> findAll(Pageable pageable);

    Page<EmployeeSalesByCountryProjection> findEmployeeSalesByCountry(LocalDateTime beginningDate, LocalDateTime endingDate, Pageable pageable);

    Page<SalesByYearProjection> findSalesByYear(LocalDateTime beginningDate, LocalDateTime endingDate, Pageable pageable);
}