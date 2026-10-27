package br.com.northwind.service.validation.impl;

import br.com.northwind.service.dto.OrderDto;
import br.com.northwind.service.validation.OrderValidation;
import br.com.northwind.service.validation.order.OrderValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderValidationImpl implements OrderValidation {
    private final List<OrderValidator> orderValidators;
    private final ValidationExecutor executor;


    @Override
    public void validateCreationOrder(OrderDto orderDto) {
        executor.validate(orderDto, orderValidators);
    }
}