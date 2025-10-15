package br.com.northwind.controller;

import br.com.northwind.service.OrderDetailService;
import br.com.northwind.service.dto.OrderDetailDto;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/order-details")
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @GetMapping("/order/{orderId}")
    @Timed
    public ResponseEntity<List<OrderDetailDto>> findByPkOrderId(@PathVariable long orderId) {
        return ResponseEntity.ok(this.orderDetailService.findByPkOrderId(orderId));
    }

    @GetMapping("/product/{productId}")
    @Timed
    public ResponseEntity<List<OrderDetailDto>> findByPkProductId(@PathVariable long productId) {
        return ResponseEntity.ok(this.orderDetailService.findByPkProductId(productId));
    }

    @GetMapping("{orderId}/{productId}")
    @Timed
    public ResponseEntity<OrderDetailDto> findByPkOrderIdAndPkProductId(@PathVariable long orderId, @PathVariable long productId) {
        return ResponseEntity.ok(this.orderDetailService.findByPkOrderIdAndPkProductId(orderId, productId));
    }
}