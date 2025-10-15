package br.com.northwind.service.projection;

import java.math.BigDecimal;

public interface ProductSalesFor1997Projection {
    String getCategoryName();
    String getProductName();
    BigDecimal getProductSales();
}