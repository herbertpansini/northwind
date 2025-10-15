package br.com.northwind.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto implements BaseDto, Serializable {
    private static final long serialVersionUID = 1L;

    Long id;

    @NotBlank
    String name;

    @NotNull
    Long categoryId;

    @NotNull
    Long supplierId;
    
    String quantityPerUnit;
    Double unitPrice;
    Integer unitsInStock;
    Integer unitsOnOrder;
    Integer reorderLevel;
    Boolean discontinued;
}