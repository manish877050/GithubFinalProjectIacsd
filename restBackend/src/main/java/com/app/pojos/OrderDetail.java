package com.app.pojos;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer id;

	// association orderDetail 1<----->many product
	@JsonManagedReference
	@OneToMany(mappedBy = "pk.order")
	private List<OrderProduct> orderProducts = new ArrayList<>();

	@CreationTimestamp
	@Column(name = "createdOn", nullable = false, updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;

	public OrderDetail() {
		System.out.println("Bean " + getClass().getName() + " Created...");
	}

	@Transient
	public Double getTotalOrderPrice() {
		Double sum = 0D;
		List<OrderProduct> orderProducts = getOrderProducts();
		for (OrderProduct op : orderProducts) {
			sum += op.getTotalPrice();
		}
		return sum;
	}

	@Transient
	public int getNumberOfProducts() {
		return this.orderProducts.size();
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

}
