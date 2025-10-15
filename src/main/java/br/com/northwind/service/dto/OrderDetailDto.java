package br.com.northwind.service.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailDto implements Serializable {
    private static final long serialVersionUID = 1L;

    Long orderId;
    Long productId;
    String productName;
    BigDecimal unitPrice;
    Integer quantity;
    BigDecimal discount;
}