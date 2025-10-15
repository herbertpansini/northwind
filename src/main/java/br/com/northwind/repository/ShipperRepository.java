package br.com.northwind.repository;

import br.com.northwind.model.Shipper;
import br.com.northwind.service.dto.ShipperListItemDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Long> {
    List<ShipperListItemDto> findAllByOrderByCompanyName();
}