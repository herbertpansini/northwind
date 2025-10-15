package br.com.northwind.service.impl;

import br.com.northwind.repository.OrderDetailRepository;
import br.com.northwind.service.OrderDetailService;
import br.com.northwind.service.dto.OrderDetailDto;
import br.com.northwind.service.mapper.OrderDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailMapper orderDetailMapper;

    @Transactional(readOnly = true)
    @Override
    public List<OrderDetailDto> findByPkOrderId(long orderId) {
        return this.orderDetailRepository.findByPkOrderId(orderId).stream().map(this.orderDetailMapper::toDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<OrderDetailDto> findByPkProductId(long productId) {
        return this.orderDetailRepository.findByPkProductId(productId).stream().map(this.orderDetailMapper::toDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public OrderDetailDto findByPkOrderIdAndPkProductId(long orderId, long productId) {
        return this.orderDetailMapper.toDto(this.orderDetailRepository.findByPkOrderIdAndPkProductId(orderId, productId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Order Detail with orderId: %d, productId: %d not found")));
    }
}