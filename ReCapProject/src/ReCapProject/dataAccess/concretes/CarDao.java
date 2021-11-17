package ReCapProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ReCapProject.dataAccess.abstracts.CarRepository;
import ReCapProject.entities.concretes.Car;

public class CarDao implements CarRepository {

	List<Car> cars;
	
	public CarDao() {
		cars=new ArrayList<Car>();
	}
	@Override
	public void add(Car entity) {

		cars.add(entity);
	}

	@Override
	public void remove(Car entity) {

		cars.remove(entity);
		
	}

	@Override
	public void update(int id,Car entity) {
		cars.set(id, entity);
		
	}

	@Override
	public Car getById(int id) {
	
		return cars.get(id-1);
	}

	@Override
	public List<Car> getAll() {
		
		return cars;
	}

}
