package br.com.northwind.service.validation.order.impl;

import br.com.northwind.service.dto.OrderDto;
import br.com.northwind.service.validation.order.OrderValidator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Component
@Order(1)
public class OrderDateValidator implements OrderValidator {
    @Override
    public Optional<String> validate(OrderDto orderDto) {
        long period = ChronoUnit.DAYS.between(orderDto.getOrderDate(), LocalDateTime.now());
        if (period < 15) {
            return Optional.of("Período deve ter no mínimo 15 dias.");
        }
        return Optional.empty();
    }
}