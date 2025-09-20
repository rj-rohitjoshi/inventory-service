package com.ecommerce.inventory.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class InventoryDto {
    private String sku;
    private Long productId;
    private int quantity;
    private String warehouse;
}
