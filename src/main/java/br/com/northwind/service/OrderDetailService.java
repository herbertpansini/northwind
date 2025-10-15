package br.com.northwind.service;

import br.com.northwind.service.dto.OrderDetailDto;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailDto> findByPkOrderId(long orderId);
    List<OrderDetailDto> findByPkProductId(long productId);
    OrderDetailDto findByPkOrderIdAndPkProductId(long orderId, long productId);
}