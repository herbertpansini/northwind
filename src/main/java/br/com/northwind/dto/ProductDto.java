package br.com.northwind.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto implements Serializable {

    private static final long serialVersionUID = 1L;

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
