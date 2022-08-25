package br.com.northwind.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class ProductDto {
    @Id
    private Long id;
    private String name;
    private CategoryDto category;
    private SupplierDto supplier;
    private String quantityPerUnit;
    private Double unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Boolean discontinued;
}
