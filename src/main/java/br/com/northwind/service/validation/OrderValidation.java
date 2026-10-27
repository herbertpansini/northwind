package br.com.northwind.service.validation;

import br.com.northwind.service.dto.OrderDto;

public interface OrderValidation {
    void validateCreationOrder(OrderDto orderDto);
}