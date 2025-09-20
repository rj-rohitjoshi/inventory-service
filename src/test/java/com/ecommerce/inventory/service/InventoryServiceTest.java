package com.ecommerce.inventory.service;

import com.ecommerce.inventory.dto.InventoryDto;
import com.ecommerce.inventory.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class InventoryServiceTest {

    @Autowired
    private InventoryService service;

    @Test
    void saveAndFindWorks() {
        InventoryDto dto = InventoryDto.builder()
                .sku("ITEM-123")
                .productId(111L)
                .quantity(24)
                .warehouse("WH-A")
                .build();
        service.createOrUpdate(dto);

        InventoryDto found = service.getBySku("ITEM-123");
        assertThat(found.getWarehouse()).isEqualTo("WH-A");
    }
}
