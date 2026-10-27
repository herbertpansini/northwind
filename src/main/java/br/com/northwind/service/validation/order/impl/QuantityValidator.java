package br.com.northwind.service.validation.order.impl;

import br.com.northwind.service.dto.OrderDto;
import br.com.northwind.service.validation.order.OrderValidator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(2)
public class QuantityValidator implements OrderValidator {
    @Override
    public Optional<String> validate(OrderDto orderDto) {
        if (orderDto.getOrderDetails().stream().anyMatch(p -> p.getProductId() == 2 && p.getQuantity() > 5)) {
            return Optional.of("O produto dois só pode ser vendido até 5 unidades por pedido");
        }
        return Optional.empty();
    }
}