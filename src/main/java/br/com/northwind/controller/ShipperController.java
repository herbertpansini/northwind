package br.com.northwind.controller;

import br.com.northwind.service.ShipperService;
import br.com.northwind.service.dto.ShipperListItemDto;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/shippers")
@RequiredArgsConstructor
public class ShipperController {
    private final ShipperService shipperService;

    @GetMapping("/list-item")
    @Timed
    public ResponseEntity<List<ShipperListItemDto>> findAllByOrderByCompanyName() {
        return ResponseEntity.ok(this.shipperService.findAllByOrderByCompanyName());
    }
}