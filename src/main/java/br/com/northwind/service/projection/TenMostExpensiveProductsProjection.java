package br.com.northwind.service.projection;

import java.math.BigDecimal;

public interface TenMostExpensiveProductsProjection {
    String getTenMostExpensiveProducts();
    BigDecimal getUnitPrice();
}