package br.com.northwind.service.projection;

public interface ProductByCategoryProjection {
    String getCategoryName();
    String getProductName();
    String getQuantityPerUnit();
    Integer getUnitsInStock();
    Boolean getDiscontinued();
}