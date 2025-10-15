package br.com.northwind.service.dto;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupplierByCityDto implements Serializable {
    private static final long serialVersionUID = 1L;

    String city;
    String companyName;
    String contactName;
}