package com.ecommerce.inventory.exception;

public class InventoryNotFoundException extends RuntimeException {
    public InventoryNotFoundException(String msg) {
        super(msg);
    }
}
