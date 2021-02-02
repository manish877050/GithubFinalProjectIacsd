
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

import com.app.pojos.Brand;
import com.app.service.IBrandService;

@RestController

@RequestMapping("/brand")
public class BrandController {

	@Autowired
	IBrandService brandService;

	public BrandController() {
		System.out.println("Bean " + getClass().getName() + " Created...");
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllBrands() {
		return new ResponseEntity<>(brandService.getAllBrands(), HttpStatus.OK);
	}

	@PostMapping("/add-brand")
	public ResponseEntity<?> addBrand(@RequestBody Brand newBrand) {
		return new ResponseEntity<>(brandService.addBrand(newBrand), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateBrand(@RequestBody Brand updateable) {
		return new ResponseEntity<>(brandService.updateBrandDetail(updateable), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBrand(@PathVariable int id) {
		return new ResponseEntity<>(brandService.deleteBrand(id), HttpStatus.OK);
	}
}
