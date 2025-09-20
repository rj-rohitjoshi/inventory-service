package com.ecommerce.inventory.service;

import com.ecommerce.inventory.dto.InventoryDto;
import java.util.List;

public interface InventoryService {
    InventoryDto createOrUpdate(InventoryDto dto);
    InventoryDto getBySku(String sku);
    List<InventoryDto> findAll();
    List<InventoryDto> findByWarehouse(String warehouse);
}
