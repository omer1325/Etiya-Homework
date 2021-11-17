package ReCapProject.business.abstracts;

import java.util.List;

import ReCapProject.core.utilities.results.DataResult;
import ReCapProject.core.utilities.results.Result;
import ReCapProject.entities.concretes.Car;

public interface CarService {
	Result add(Car car);
	Result remove(Car car);
	Result update(int id,Car car);
	DataResult<Car> getById(int id);
	DataResult<List<Car>> getAll();
}
