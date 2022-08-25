package br.com.northwind.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductAboveAveragePriceDto {
    private String name;
    private Double unitPrice;
}