package br.com.northwind.service.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryListDto implements BaseDto, Serializable {
	private static final long serialVersionUID = 1L;
	
    Long id;
    String name;
    String description;
}