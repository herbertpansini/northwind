package br.com.northwind.service;

import br.com.northwind.service.dto.ShipperListItemDto;

import java.util.List;

public interface ShipperService {
    List<ShipperListItemDto> findAllByOrderByCompanyName();
}