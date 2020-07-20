package com.dbs.order.item.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TBL_ORDERITEM")
@Getter
@Setter
@ToString
public class OrderItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="PRODUCT_CODE")
	private long productCode;
	
	@Column(name="PRODUCT_NAME")
	@NotEmpty(message = "Order item name can't be empty")
	private String productName;
	
	@Column(name="QUANTITY")
	@NotNull(message = "Product Quantity can't be empty")
	@Min(value = 1, message = "Order item quantity must be greater than or equal to 1")
	private int quantity;

}
