package com.ecommerce.inventory.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("inventory")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class InventoryItem {
    @Id
    private String sku;
    private Long productId;
    private int quantity;
    private String warehouse; // Optional for findByWarehouse use-case
}
