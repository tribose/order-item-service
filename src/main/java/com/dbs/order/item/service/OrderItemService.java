package com.dbs.order.item.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.order.item.exception.OrderItemNotFoundException;
import com.dbs.order.item.model.OrderItem;
import com.dbs.order.item.repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	public List<OrderItem> getAllOrderItems() throws OrderItemNotFoundException{
		List<OrderItem> orderItemList = orderItemRepository.findAll();
		
		if(orderItemList.size() > 0) {
			return orderItemList;
		}else {
			throw new OrderItemNotFoundException("Order Items aren't available. Please create Order Item");
		}	
	}
	
	public OrderItem getOrderById(Long id) throws OrderItemNotFoundException {
		
		Optional<OrderItem> order = orderItemRepository.findByProductCode(id);
		if(order.isPresent()) {
			return order.get();
		}else {
			throw new OrderItemNotFoundException("Order Item Not Found. Please try something else");
		}
	}
	
	public OrderItem findOrderItemByProduct_Name(String product_name) throws OrderItemNotFoundException {
		
		Optional<OrderItem> orderItem = orderItemRepository.findByProductName(product_name);
		if(orderItem.isPresent()) {
			return orderItem.get();
		}else {
			throw new OrderItemNotFoundException("Order Item Not Found. Please try something else or create new order item");
		}
	}
	
	public OrderItem createOrUpdateOrderItem(OrderItem orderItem) {
		
		Optional<OrderItem> item = orderItemRepository.findByProductName(orderItem.getProductName());
		if(item.isPresent()) {
			OrderItem newOrderItem = item.get();
			newOrderItem.setQuantity(orderItem.getQuantity());
			newOrderItem = orderItemRepository.save(newOrderItem);
			
			return newOrderItem;
		}else {
			orderItem.setProductCode(ThreadLocalRandom.current().nextLong(3030000, 3090000));
			orderItem = orderItemRepository.save(orderItem);
			
			return orderItem;
		}		
	}
}
