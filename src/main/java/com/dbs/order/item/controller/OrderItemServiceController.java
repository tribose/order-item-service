package com.dbs.order.item.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.order.item.exception.OrderItemNotFoundException;
import com.dbs.order.item.model.OrderItem;
import com.dbs.order.item.service.OrderItemService;

@RestController
@RequestMapping("/items")
@Validated
public class OrderItemServiceController {

	@Autowired
	OrderItemService orderItemService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public List<OrderItem> getAllOrderItems(){
		
		return orderItemService.getAllOrderItems();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public OrderItem getOrderItemById(@PathVariable @Min(value = 1, message = "Order item id must be greater than or equal to 1")  Long id) throws OrderItemNotFoundException {
		
		return orderItemService.getOrderById(id);
	}
	
	@GetMapping(value = "/product/{productName}", produces = MediaType.APPLICATION_JSON)
	public OrderItem getOrderItemByProductName(@PathVariable("productName") @NotEmpty String productName) throws OrderItemNotFoundException {
		System.out.println("getOrderItemByProductName :"+productName);
		return orderItemService.findOrderItemByProduct_Name(productName);
	}
	
	@PostMapping
	public OrderItem createOrUpdateOrder(@Valid @RequestBody OrderItem orderItem) {
		System.out.println("orderItem.toString() :"+orderItem.toString());
		OrderItem orderItemResponse = orderItemService.createOrUpdateOrder(orderItem);
		return orderItemResponse;
	}
}
