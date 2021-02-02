package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ResponseDTO;
import com.app.pojos.Admin;
import com.app.repository.AdminRepository;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	AdminRepository repository;

	public AdminServiceImpl() {
		System.out.println("bean " + getClass().getName() + " Created...");
	}

	@Override
	public ResponseDTO signup(Admin adminDetails) {
		repository.save(adminDetails);
		return new ResponseDTO("success", "Details Found Successfully", adminDetails); 
	}

	@Override
	public ResponseDTO login(Admin adminDetails) {

		Admin temp = repository.findByEmail(adminDetails.getEmail());
		if (temp != null) {
			if (adminDetails.getPassword().equals(temp.getPassword()))
				return new ResponseDTO("success", "Details Found Successfully", temp);
			else
				return new ResponseDTO("error", "Admin Details Not Found");

		} else {
			return new ResponseDTO("error", "Admin Details Not Found");
		}
	}

	@Override
	public ResponseDTO deleteAccount(Integer Id) {
		 repository.deleteById(Id);
		return new ResponseDTO("success", "Account Deleted successfully");
	}

}
