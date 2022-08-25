package br.com.northwind.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductByCategoryDto {
    private String categoryName;
    private String productName;
    private String quantityPerUnit;
    private Integer unitsInStock;
    private Boolean discontinued;
}