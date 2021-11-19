package com.etiya.rentACarSpring.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACarSpring.entities.Brand;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
	
	
	@GetMapping("check")
	public String check() {
		return "API up";
	}
	
	@GetMapping("all")
	public List<Brand> getAll(){
		List<Brand> brands=new ArrayList<Brand>();
		
		brands.add(new Brand(1,"Opel"));
		brands.add(new Brand(2,"Renault"));
		
		return brands;
	}

}
