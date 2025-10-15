package br.com.northwind.controller;

import br.com.northwind.service.OrderService;
import br.com.northwind.service.dto.OrderDto;
import br.com.northwind.service.projection.EmployeeSalesByCountryProjection;
import br.com.northwind.service.projection.SalesByYearProjection;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    @Timed
    public ResponseEntity<Page<OrderDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(this.orderService.findAll(pageable));
    }

    @GetMapping("employee-sales-by-country")
    @Timed
    public ResponseEntity<Page<EmployeeSalesByCountryProjection>> findEmployeeSalesByCountry(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime beginningDate,
                                                                                             @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endingDate,
                                                                                             Pageable pageable) {
        return ResponseEntity.ok(this.orderService.findEmployeeSalesByCountry(beginningDate, endingDate, pageable));
    }

    @GetMapping("sales-by-year")
    @Timed
    public ResponseEntity<Page<SalesByYearProjection>> findSalesByYear(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime beginningDate,
                                                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endingDate,
                                                                       Pageable pageable) {
        return ResponseEntity.ok(this.orderService.findSalesByYear(beginningDate, endingDate, pageable));
    }
}