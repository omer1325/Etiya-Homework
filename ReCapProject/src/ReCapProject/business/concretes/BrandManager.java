package ReCapProject.business.concretes;

import java.util.List;

import ReCapProject.business.abstracts.BrandService;
import ReCapProject.core.utilities.results.DataResult;
import ReCapProject.core.utilities.results.ErrorResult;
import ReCapProject.core.utilities.results.Result;
import ReCapProject.core.utilities.results.SuccessDataResult;
import ReCapProject.core.utilities.results.SuccessResult;
import ReCapProject.dataAccess.abstracts.BrandRepository;
import ReCapProject.entities.concretes.Brand;


public class BrandManager implements BrandService {
	
	private BrandRepository brandRepository;
	
	public BrandManager(BrandRepository brandrepository) {
		this.brandRepository = brandrepository;
	}

	@Override
	public Result add(Brand brand) {
		this.brandRepository.add(brand);
		return new SuccessResult("Marka eklendi"+brand.getName());
	}

	@Override
	public Result remove(Brand brand) {
		this.brandRepository.remove(brand);
		return new SuccessResult("Marka silindi"+brand.getName());
	}

	@Override
	public Result update(int id,Brand brand) {
		int index=0;
		for (Brand elements : this.brandRepository.getAll()) {
			if(id == elements.getId()) {
				index =this.brandRepository.getAll().indexOf(brand);
				this.brandRepository.update(id, brand);
				return new SuccessResult("Renk Güncellendi");
			}
		}
		return new ErrorResult("Böyle bir renk yok.");
	}

	@Override
	public DataResult<Brand> getById(int id) {
		return new SuccessDataResult<Brand>(this.brandRepository.getById(id), "Listelendi");
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		return new SuccessDataResult<List<Brand>>(this.brandRepository.getAll(), "Markalar listelendi.");
	}

}
