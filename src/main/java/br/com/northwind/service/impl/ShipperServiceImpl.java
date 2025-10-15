package br.com.northwind.service.impl;

import br.com.northwind.repository.ShipperRepository;
import br.com.northwind.service.ShipperService;
import br.com.northwind.service.dto.ShipperListItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ShipperServiceImpl implements ShipperService {
    private final ShipperRepository shipperRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ShipperListItemDto> findAllByOrderByCompanyName() {
        return this.shipperRepository.findAllByOrderByCompanyName();
    }
}