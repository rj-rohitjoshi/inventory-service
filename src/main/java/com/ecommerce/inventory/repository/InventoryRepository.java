package com.ecommerce.inventory.repository;

import com.ecommerce.inventory.model.InventoryItem;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface InventoryRepository extends CrudRepository<InventoryItem, String> {
    List<InventoryItem> findByWarehouse(String warehouse);
}
