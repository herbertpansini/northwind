package br.com.northwind.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class CategoryDto {
    @Id
    private Long id;
    private String name;
    private String description;
}
