package com.etiya.rentACarSpring.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACarSpring.entities.Color;

@RestController
@RequestMapping("api/colors")
public class ColorsController {

	@GetMapping("check")
	public String check() {
		return "API up";
	}
	
	@GetMapping("all")
	public List<Color> getAll(){
		List<Color> colors=new ArrayList<Color>();
		colors.add(new Color(1,"black"));
		colors.add(new Color(1,"white"));
		colors.add(new Color(1,"blue"));
		
		return colors;
	}

}
