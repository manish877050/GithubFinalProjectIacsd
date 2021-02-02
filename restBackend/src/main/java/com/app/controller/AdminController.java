package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	private IAdminService adminService;

	public AdminController() {
		System.out.println("bean " + getClass().getName() + " created");
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody Admin adminDetails) {
		return new ResponseEntity<>(adminService.signup(adminDetails), HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Admin adminDetails) {
		System.out.println("un-Martialed data " + adminDetails);
		return new ResponseEntity<>(adminService.login(adminDetails), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable Integer id) {
		return new ResponseEntity<>(adminService.deleteAccount(id), HttpStatus.OK);

	}

}
