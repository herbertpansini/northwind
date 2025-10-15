package br.com.northwind.service.projection;

public interface AlphabeticalListOfProductsProjection {
    Long getProductId();
    String getProductName();
    Long getCategoryId();
    Long getSupplierId();
    String getQuantityPerUnit();
    Double getUnitPrice();
    Integer getUnitsInStock();
    Integer getUnitsOnOrder();
    Integer getReorderLevel();
    Boolean getDiscontinued();
    String getCategoryName();
}