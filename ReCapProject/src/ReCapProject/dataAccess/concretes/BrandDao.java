package ReCapProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ReCapProject.dataAccess.abstracts.BrandRepository;
import ReCapProject.entities.concretes.Brand;

public class BrandDao implements BrandRepository {

	List<Brand> brands;
	
	public BrandDao() {
		brands=new ArrayList<Brand>();
		
	}
	@Override
	public void add(Brand entity) {
		// TODO Auto-generated method stub
		brands.add(entity);
	}

	@Override
	public void remove(Brand entity) {
		// TODO Auto-generated method stub
		brands.remove(entity);
	}

	@Override
	public void update(int id,Brand entity) {
		brands.set(id, entity);
		
	}

	@Override
	public Brand getById(int id) {
		// TODO Auto-generated method stub
		return brands.get(id-1);
	}

	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brands;
	}

}
