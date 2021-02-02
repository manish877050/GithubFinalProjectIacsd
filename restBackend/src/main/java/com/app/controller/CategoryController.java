package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Category;
import com.app.service.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	ICategoryService service;

	public CategoryController() {
		System.out.println("Bean " + getClass().getName() + " created...");

	}
	@GetMapping("/")
	public ResponseEntity<?> getAllCategory() {
		return new ResponseEntity<>(service.getAllCategory(), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> addCategory(@RequestBody Category newCategory) {
		System.out.println(newCategory);
		return new ResponseEntity<>(service.createCategory(newCategory),HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable int id) {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable int id) {
		return new ResponseEntity<>(service.deleteCategory(id),HttpStatus.OK);
	}

}
