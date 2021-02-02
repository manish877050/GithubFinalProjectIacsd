
package com.app.service;

import com.app.dto.ResponseDTO;
import com.app.pojos.Brand;

public interface IBrandService {
	ResponseDTO addBrand(Brand newBrand);

	ResponseDTO getAllBrands();

	ResponseDTO updateBrandDetail(Brand existingBrand);

	ResponseDTO deleteBrand(int id);
}
