package br.com.northwind.service.mapper;

import java.util.List;

import br.com.northwind.model.BaseEntity;
import br.com.northwind.service.dto.BaseDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@MapperConfig
public interface EntityMapper<D extends BaseDto, E extends BaseEntity> {
    E toEntity(D dto);
    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);
    List <D> toDto(List<E> entityList);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(D dto, @MappingTarget E entity);
}