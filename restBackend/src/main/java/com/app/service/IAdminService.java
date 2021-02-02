package com.app.service;

import com.app.dto.ResponseDTO;
import com.app.pojos.Admin;

public interface IAdminService {
	
	ResponseDTO signup(Admin adminDetails);
	ResponseDTO login(Admin adminDetails);
	ResponseDTO deleteAccount(Integer Id);
 

}
