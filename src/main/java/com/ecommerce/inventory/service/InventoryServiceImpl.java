package com.ecommerce.inventory.service;

import com.ecommerce.inventory.dto.InventoryDto;
import com.ecommerce.inventory.model.InventoryItem;
import com.ecommerce.inventory.repository.InventoryRepository;
import com.ecommerce.inventory.exception.InventoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service @RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository repo;

    @Override
    public InventoryDto createOrUpdate(InventoryDto dto) {
        InventoryItem item = InventoryItem.builder()
                .sku(dto.getSku())
                .productId(dto.getProductId())
                .quantity(dto.getQuantity())
                .warehouse(dto.getWarehouse())
                .build();
        repo.save(item);
        return dto;
    }

    @Override
    public InventoryDto getBySku(String sku) {
        InventoryItem item = repo.findById(sku)
                .orElseThrow(() -> new InventoryNotFoundException("Not found: " + sku));
        return InventoryDto.builder()
                .sku(item.getSku())
                .productId(item.getProductId())
                .quantity(item.getQuantity())
                .warehouse(item.getWarehouse())
                .build();
    }

    @Override
    public List<InventoryDto> findAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .map(item -> InventoryDto.builder()
                        .sku(item.getSku()).productId(item.getProductId())
                        .quantity(item.getQuantity()).warehouse(item.getWarehouse())
                        .build())
                .toList();
    }

    @Override
    public List<InventoryDto> findByWarehouse(String warehouse) {
        return repo.findByWarehouse(warehouse).stream()
                .map(item -> InventoryDto.builder()
                        .sku(item.getSku()).productId(item.getProductId())
                        .quantity(item.getQuantity()).warehouse(item.getWarehouse())
                        .build())
                .toList();
    }
}
