
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

import com.app.dto.ResponseDTO;
import com.app.pojos.Brand;
import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.service.IProductService;

@RestController

@RequestMapping("/product")
public class ProductController {

	@Autowired
	IProductService productService;

	public ProductController() {
		System.out.println("Bean " + getClass().getName() + " Created...");
	}

	@GetMapping("/")
	public ResponseEntity<?> getProduct() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/single/{id}")
	public ResponseEntity<?> getSignleProduct(@PathVariable Integer id) {
		return new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.OK);
	}
	
	@PostMapping("/brand")
	public ResponseEntity<?> getProductByBrand(@RequestBody Brand brand) {
		return new ResponseEntity<>(productService.getProductByBrand(brand), HttpStatus.OK);
	}
	
	@PostMapping("/category")
	public ResponseEntity<?> getProductByCategory(@RequestBody Category category) {
		return new ResponseEntity<>(productService.getProductByCategory(category), HttpStatus.OK);
	}

	@PutMapping("/edit")
	public ResponseEntity<?> editProduct(@RequestBody Product product) {
		// productService.save(product);
		return new ResponseEntity<>(new ResponseDTO("success", "Product Updated SuccessFully", product), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> createProduct(@RequestBody Product newProduct) {

		return new ResponseEntity<>(
				new ResponseDTO("success", "Product Strored SuccessFully", productService.createProduct(newProduct)),
				HttpStatus.OK);
	}

	@PostMapping("/update-state/{id}/{state}")
	public ResponseEntity<?> updateActiveState(@PathVariable int id, @PathVariable int state) {
		return new ResponseEntity<>(new ResponseDTO("success", "Status Updated succesfully updates"), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateProduct() {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id) {
		// productRepository.deleteById(id);
		return new ResponseEntity<>(new ResponseDTO("success", "Product Deleted"), HttpStatus.OK);
	}

}
