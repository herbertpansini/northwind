package br.com.northwind.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
public class CurrentProductDto {
    @Id
    private Long id;
    private String name;
}