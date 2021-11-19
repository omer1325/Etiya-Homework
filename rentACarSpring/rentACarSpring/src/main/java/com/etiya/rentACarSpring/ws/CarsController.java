package com.etiya.rentACarSpring.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACarSpring.entities.Car;

@RestController
@RequestMapping("api/cars")
public class CarsController {

	@GetMapping("check")
	public String check() {
		return "API up";
	}

	@GetMapping("all")
	public List<Car> getAll() {
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car(1, 1, 1, 2014, "Opel Astra"));
		cars.add(new Car(1, 1, 1, 2014, "Renault Clio"));

		return cars;
	}

}
