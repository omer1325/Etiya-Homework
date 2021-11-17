package ReCapProject.business.concretes;

import java.util.List;

import ReCapProject.business.abstracts.CarService;
import ReCapProject.core.utilities.results.DataResult;
import ReCapProject.core.utilities.results.ErrorResult;
import ReCapProject.core.utilities.results.Result;
import ReCapProject.core.utilities.results.SuccessDataResult;
import ReCapProject.core.utilities.results.SuccessResult;
import ReCapProject.dataAccess.abstracts.CarRepository;
import ReCapProject.entities.concretes.Car;


public class CarManager implements CarService {
	
	private CarRepository carRepository;
	
	public CarManager(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public Result add(Car car) {
		this.carRepository.add(car);
		
		return new SuccessResult("Araba eklendi"+car.getDescription());
	}

	@Override
	public Result remove(Car car) {
		this.carRepository.remove(car);
		return new SuccessResult("Araba silindi"+car.getDescription());
	}

	@Override
	public Result update(int id,Car car) {
		int index=0;
		for (Car elements : this.carRepository.getAll()) {
			if(id==elements.getId()) {
				index=this.carRepository.getAll().indexOf(elements);
				this.carRepository.update(index, car);
				return new SuccessResult("Renk Güncellendi");
			}				
		}
		return new ErrorResult("Böyle bir renk yok.");
	}

	@Override
	public DataResult<Car> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Car>(carRepository.getById(id), "Listelendi");
	}

	@Override
	public DataResult<List<Car>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Car>>(carRepository.getAll(), "Arabalar listelendi");
	}

}
