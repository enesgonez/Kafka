package com.pia.inventorymanagement.repository;

import com.pia.inventorymanagement.document.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory,String> {

    List<Inventory> findByOrderId(String orderId);

}
