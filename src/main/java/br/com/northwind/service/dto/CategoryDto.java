package br.com.northwind.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDto implements BaseDto, Serializable {
	private static final long serialVersionUID = 1L;
	
    Long id;

    @NotBlank
    String name;
    
    String description;
}