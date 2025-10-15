package br.com.northwind.service.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto implements BaseDto, Serializable {
    private static final long serialVersionUID = 1L;

    Long id;
    CustomerDto customer;
    EmployeeDto employee;
    LocalDateTime orderDate;
    LocalDateTime requiredDate;
    LocalDateTime shippedDate;
    Integer shipVia;
    BigDecimal freight;
    String shipName;
    String shipAddress;
    String shipCity;
    String shipRegion;
    String shipPostalCode;
    String shipCountry;
    Set<OrderDetailDto> orderDetails = new HashSet<>();
}