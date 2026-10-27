package br.com.northwind.service.impl;

import br.com.northwind.repository.OrderRepository;
import br.com.northwind.service.OrderService;
import br.com.northwind.service.dto.OrderDto;
import br.com.northwind.service.mapper.OrderMapper;
import br.com.northwind.service.projection.EmployeeSalesByCountryProjection;
import br.com.northwind.service.projection.SalesByYearProjection;
import br.com.northwind.service.validation.OrderValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderValidation orderValidation;

    @Override
    public OrderDto save(OrderDto orderDto) {
        this.orderValidation.validateCreationOrder(orderDto);

        return this.orderMapper.toDto(this.orderRepository.save(this.orderMapper.toEntity(orderDto)));
    }

    @Transactional(readOnly = true)
    @Override
    public Page<OrderDto> findAll(Pageable pageable) {
        return this.orderRepository.findAll(pageable).map(this.orderMapper::toDto);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<EmployeeSalesByCountryProjection> findEmployeeSalesByCountry(LocalDateTime beginningDate, LocalDateTime endingDate, Pageable pageable) {
        return this.getPaginatedList(this.orderRepository.findEmployeeSalesByCountry(beginningDate, endingDate), pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<SalesByYearProjection> findSalesByYear(LocalDateTime beginningDate, LocalDateTime endingDate, Pageable pageable) {
         return this.getPaginatedList(this.orderRepository.findSalesByYear(beginningDate, endingDate), pageable);
    }

    private <T> PageImpl<T> getPaginatedList(List<T> content, Pageable pageable) {
        int startIdx = (pageable.getPageNumber()) * pageable.getPageSize();

        if (startIdx >= content.size()) {
            return new PageImpl<>(Collections.emptyList(), pageable, content.size());
        }

        int endIdx = Math.min(startIdx + pageable.getPageSize(), content.size());
        return new PageImpl<>(content.subList(startIdx, endIdx), pageable, content.size());
    }
}