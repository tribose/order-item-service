package com.dbs.order.item.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.order.item.exception.OrderItemNotFoundException;
import com.dbs.order.item.model.OrderItem;
import com.dbs.order.item.repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	public List<OrderItem> getAllOrderItems(){
		List<OrderItem> orderItemList = orderItemRepository.findAll();
		
		if(orderItemList.size() > 0) {
			return orderItemList;
		}else {
			return new ArrayList<OrderItem>();
		}	
	}
	
	public OrderItem getOrderById(Long id) throws OrderItemNotFoundException {
		
		Optional<OrderItem> order = orderItemRepository.findById(id);
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
			throw new OrderItemNotFoundException("Order Item Not Found. Please try something else");
		}
	}
	
	public OrderItem createOrUpdateOrder(OrderItem orderItem) {
		
		Optional<OrderItem> item = orderItemRepository.findById(orderItem.getId());
		if(item.isPresent()) {
			OrderItem newOrderItem = item.get();
			newOrderItem.setProductCode(orderItem.getProductCode());
			newOrderItem.setProductName(orderItem.getProductName());
			newOrderItem.setQuantity(orderItem.getQuantity());
			
			newOrderItem = orderItemRepository.save(newOrderItem);
			return newOrderItem;
		}else {
			orderItem = orderItemRepository.save(orderItem);
			return orderItem;
		}
	}
}
