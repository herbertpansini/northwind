package br.com.northwind.service.projection;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface SalesByYearProjection {
    LocalDateTime getShippedDate();
    Long getOrderId();
    BigDecimal getSubtotal();
    String getYear();
}