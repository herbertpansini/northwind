package br.com.northwind.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SupplierByCityDto {
    private String city;
    private String companyName;
    private String contactName;
}