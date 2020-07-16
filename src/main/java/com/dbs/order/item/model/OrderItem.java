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

@Entity
@Table(name = "TBL_ORDERITEM")
public class OrderItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
    private Long id;
	
	@Column(name="PRODUCT_CODE")
	@NotEmpty(message = "Order item code can't be empty")
	private String productCode;
	
	@Column(name="PRODUCT_NAME")
	@NotEmpty(message = "Order item name can't be empty")
	private String productName;
	
	@Column(name="QUANTITY")
	@NotNull(message = "Product Quantity can't be empty")
	@Min(value = 1, message = "Order item quantity must be greater than or equal to 1")
	private int quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", productCode=" + productCode + ", productName=" + productName
				+ ", quantity=" + quantity + "]";
	}
}
