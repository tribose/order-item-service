package com.dbs.order.item.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.order.item.model.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
	public Optional<OrderItem> findByProductName(String product_name);
	
	public Optional<OrderItem> findByProductCode(Long productCode);
}
