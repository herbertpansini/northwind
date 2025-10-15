package br.com.northwind.service.mapper;

import br.com.northwind.model.OrderDetail;
import br.com.northwind.service.dto.OrderDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    @Mapping(source = "pk.orderId", target = "orderId")
    @Mapping(source = "pk.productId", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    OrderDetailDto toDto(OrderDetail orderDetail);


    @Mapping(target = "pk.orderId", source = "orderId")
    @Mapping(target = "pk.productId", source = "productId")
    @Mapping(target = "order", ignore = true)
    @Mapping(target = "product", ignore = true)
    OrderDetail toEntity(OrderDetailDto orderDetailDto);

    List<OrderDetailDto> toDto(List<OrderDetail> orderDetails);

    List<OrderDetail> toEntity(List<OrderDetailDto> orderDetailDtoList);
}