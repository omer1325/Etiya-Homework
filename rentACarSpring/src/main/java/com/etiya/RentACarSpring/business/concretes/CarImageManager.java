package com.etiya.RentACarSpring.business.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.etiya.RentACarSpring.business.abstracts.CarImageService;
import com.etiya.RentACarSpring.business.constants.Messages;
import com.etiya.RentACarSpring.business.dtos.CarImageDto;
import com.etiya.RentACarSpring.business.requests.carImage.CreateCarImageRequest;
import com.etiya.RentACarSpring.business.requests.carImage.DeleteCarImageRequest;
import com.etiya.RentACarSpring.business.requests.carImage.UpdateCarImageRequest;
import com.etiya.RentACarSpring.core.business.BusinessRules;
import com.etiya.RentACarSpring.core.business.ImagePath;
import com.etiya.RentACarSpring.core.results.*;
import com.etiya.RentACarSpring.dataAccsess.abstracts.CarImageDao;
import com.etiya.RentACarSpring.entities.concretes.Car;
import com.etiya.RentACarSpring.entities.concretes.CarImage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarImageManager implements CarImageService {

	CarImageDao carImageDao;
	private ModelMapper modelMapper;

	@Autowired
	public CarImageManager(CarImageDao carImageDao, ModelMapper modelMapper) {
		super();
		this.carImageDao = carImageDao;
		this.modelMapper = modelMapper;

	}

	@Override
	public DataResult<List<CarImageDto>> getAll() {

		List<CarImage> carImages = this.carImageDao.findAll();

		List<CarImageDto> carImageDtos = carImages.stream()
				.map(carImage -> modelMapper.map(carImage, CarImageDto.class)).collect(Collectors.toList());

		return new SuccessDataResult<List<CarImageDto>>(carImageDtos, Messages.CARIMAGELIST);

	}

	@Override
	public Result add(CreateCarImageRequest createCarImageRequest) throws IOException {

		var result = BusinessRules.run(checkIfCarImageOverRun(createCarImageRequest.getCarId(), 5));

		if (result != null) {
			return result;
		}

		String imagePath = java.util.UUID.randomUUID().toString();

		File imageFile = new File(ImagePath.carImagesFileWay + imagePath + "." + createCarImageRequest.getFile()
				.getContentType().substring(createCarImageRequest.getFile().getContentType().indexOf("/") + 1));

		imageFile.createNewFile();
		FileOutputStream outputImage = new FileOutputStream(imageFile);
		outputImage.write(createCarImageRequest.getFile().getBytes());
		outputImage.close();

		Car car = new Car();
		car.setCarId(createCarImageRequest.getCarId());

		CarImage carImage = new CarImage();
		carImage.setDate(LocalDate.now());
		carImage.setImagePath(imageFile.toString());
		carImage.setCar(car);

		this.carImageDao.save(carImage);

		return new SuccessResult(Messages.CARIMAGEADD);

	}

	@Override
	public DataResult<List<CarImageDto>> getImagesWıthCarId(int carId) {

		return new SuccessDataResult<List<CarImageDto>>(returnCarImageWithDefaultImageIfCarImageIsNull(carId),
				Messages.CARIMAGELIST);

	}

	private List<CarImageDto> returnCarImageWithDefaultImageIfCarImageIsNull(int carId) {

		if (this.carImageDao.getByCar_CarId(carId).isEmpty()) {

			CarImageDto carImage = new CarImageDto();
			carImage.setImagePath(ImagePath.defaultImageFileWay);

			List<CarImageDto> carImages = new ArrayList<CarImageDto>();
			carImages.add(carImage);

			return carImages;

		}
		List<CarImage> carImages = this.carImageDao.getByCar_CarId(carId);
		List<CarImageDto> carImageDtos = carImages.stream()
				.map(carImage -> modelMapper.map(carImage, CarImageDto.class)).collect(Collectors.toList());

		return new ArrayList<CarImageDto>(carImageDtos);

	}

	@Override
	public Result update(UpdateCarImageRequest updateCarImageRequest) throws IOException {

		var result = BusinessRules.run(checkIfCarImageOverRun(updateCarImageRequest.getCarId(), 5));
		if (result != null) {
			return result;
		}

		String imagePath = java.util.UUID.randomUUID().toString();

		File imageFile = new File(ImagePath.carImagesFileWay + imagePath + "." + updateCarImageRequest.getFile()
				.getContentType().substring(updateCarImageRequest.getFile().getContentType().indexOf("/") + 1));

		imageFile.createNewFile();
		FileOutputStream outputImage = new FileOutputStream(imageFile);
		outputImage.write(updateCarImageRequest.getFile().getBytes());
		outputImage.close();

		Car car = new Car();
		car.setCarId(updateCarImageRequest.getCarId());

		CarImage carImage = this.carImageDao.getById(updateCarImageRequest.getImageId());
		carImage.setDate(LocalDate.now());
		carImage.setImagePath(imageFile.toString());
		carImage.setCar(car);

		this.carImageDao.save(carImage);

		return new SuccessResult(Messages.CARIMAGEUPDATE);

	}

	@Override
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) {
		Car car = new Car();
		car.setCarId(deleteCarImageRequest.getCarId());

		CarImage carImage = new CarImage();
		carImage.setImageId(deleteCarImageRequest.getCarId());
		carImage.setCar(car);

		this.carImageDao.save(carImage);
		return new SuccessResult(Messages.CARIMAGEDELETE);
	}

	public Result checkIfCarImageOverRun(int carId, int limit) {
		if (this.carImageDao.getByCar_CarId(carId).size() >= limit) {
			return new ErrorResult(Messages.ERROR);
		}

		return new SuccessResult(Messages.SUCCESS);
	}

}
