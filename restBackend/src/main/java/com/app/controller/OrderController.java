package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

	public OrderController() {
		System.out.println("Bean " + getClass().getName() + " Created...");

	}
	
	@GetMapping("/")
	public ResponseEntity<?> getOrderDetails() {
		return null;
	}

	@PostMapping("/add")
	public ResponseEntity<?> addOrder() {
		return null;
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateOrder() {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable int id) {
		return null;
	}

}
