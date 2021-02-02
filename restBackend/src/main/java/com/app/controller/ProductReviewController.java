package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ProductReviewController {

	public ProductReviewController() {
		System.out.println("Bean " + getClass().getName() + " Created");
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getProductReview() {
		return null;
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProductReview(@PathVariable int id) {
		return null;
	}

}
