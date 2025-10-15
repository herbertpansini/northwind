package br.com.northwind.service.mapper;

import br.com.northwind.model.Order;
import br.com.northwind.service.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, EmployeeMapper.class, OrderDetailMapper.class})
public interface OrderMapper extends EntityMapper<OrderDto, Order> {

}