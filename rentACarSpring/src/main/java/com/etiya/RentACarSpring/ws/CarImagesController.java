package com.etiya.RentACarSpring.ws;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.abstracts.CarImageService;
import com.etiya.RentACarSpring.business.dtos.CarImageDto;
import com.etiya.RentACarSpring.business.requests.carImage.CreateCarImageRequest;
import com.etiya.RentACarSpring.business.requests.carImage.DeleteCarImageRequest;
import com.etiya.RentACarSpring.business.requests.carImage.UpdateCarImageRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("api/car_images")
public class CarImagesController {

	 CarImageService carImageService;

	@Autowired
	public CarImagesController(CarImageService carImageService) {
		super();
		this.carImageService = carImageService;
	}

	@GetMapping("/getall")
	public DataResult<List<CarImageDto>> getAll() {
		return this.carImageService.getAll();
	}

	@GetMapping("/getbycarid")
	public DataResult<List<CarImageDto>> getByCarId(int carId) {
		return this.carImageService.getImagesWıthCarId(carId);
	}


	@PostMapping("/add")
	public Result add(@Valid @RequestParam ("carId") int carId, MultipartFile file) throws IOException {
		CreateCarImageRequest createCarImageRequest = new CreateCarImageRequest();
		createCarImageRequest.setCarId(carId);
		createCarImageRequest.setFile(file);
		
			
		return this.carImageService.add(createCarImageRequest);
	}

	@PostMapping("/update")
	public Result update(@Valid @RequestParam ("carId") int carId, @RequestParam ("imageId") int imageId, MultipartFile file) throws IOException{
		UpdateCarImageRequest updateCarImageRequest = new UpdateCarImageRequest();
		updateCarImageRequest.setCarId(carId);
		updateCarImageRequest.setFile(file);
		updateCarImageRequest.setImageId(imageId);
		return this.carImageService.update(updateCarImageRequest);
	}

	@PutMapping("/delete")
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) {
		return this.carImageService.delete(deleteCarImageRequest);
	}

}
