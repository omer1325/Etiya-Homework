package ReCapProject.business.abstracts;

import java.util.List;

import ReCapProject.core.utilities.results.DataResult;
import ReCapProject.core.utilities.results.Result;
import ReCapProject.entities.concretes.Brand;

public interface BrandService {
	Result add(Brand brand);
	Result remove(Brand brand);
	Result update(int id,Brand brand);
	DataResult<Brand> getById(int id);
	DataResult<List<Brand>> getAll();
	
}
