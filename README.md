# Inventory Service

Standalone Spring Boot microservice for e-commerce inventory management, backed by Redis.

## Build and Run
mvn clean package
mvn spring-boot:run

or
docker build -t inventory-service .
docker run -p 8082:8082 inventory-service

## REST API

- `POST /inventory` - create or update inventory item
- `GET /inventory` - list all items
- `GET /inventory/{sku}` - get item by SKU
- `GET /inventory/warehouse/{warehouse}` - all items in warehouse

## Test

mvn test


Uses in-memory Redis (testcontainers).

---


