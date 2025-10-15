package br.com.northwind.service.projection;

public interface EmployeeSalesByCountryProjection {
    String getCountry();
    String getLastName();
    String getFirstName();
    java.time.LocalDateTime getShippedDate();
    Integer getOrderId();
    java.math.BigDecimal getSaleAmount();
}