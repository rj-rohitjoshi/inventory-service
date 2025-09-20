package com.ecommerce.inventory.controller;

import com.ecommerce.inventory.dto.InventoryDto;
import com.ecommerce.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService service;

    @PostMapping
    public ResponseEntity<InventoryDto> createOrUpdate(@RequestBody InventoryDto dto) {
        return ResponseEntity.ok(service.createOrUpdate(dto));
    }

    @GetMapping("/{sku}")
    public ResponseEntity<InventoryDto> getBySku(@PathVariable String sku) {
        return ResponseEntity.ok(service.getBySku(sku));
    }

    @GetMapping
    public ResponseEntity<List<InventoryDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/warehouse/{warehouse}")
    public ResponseEntity<List<InventoryDto>> getByWarehouse(@PathVariable String warehouse) {
        return ResponseEntity.ok(service.findByWarehouse(warehouse));
    }
}
