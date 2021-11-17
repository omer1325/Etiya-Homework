package ReCapProject.business.concretes;

import java.util.List;

import ReCapProject.business.abstracts.ColorService;
import ReCapProject.core.utilities.results.DataResult;
import ReCapProject.core.utilities.results.ErrorResult;
import ReCapProject.core.utilities.results.Result;
import ReCapProject.core.utilities.results.SuccessDataResult;
import ReCapProject.core.utilities.results.SuccessResult;
import ReCapProject.dataAccess.abstracts.ColorRepository;
import ReCapProject.entities.concretes.Color;

public class ColorManager implements ColorService {

	private ColorRepository colorRepository;
	
	public ColorManager(ColorRepository colorRepository) {
		this.colorRepository = colorRepository;
	}

	@Override
	public Result add(Color color) {
		this.colorRepository.add(color);
		return new SuccessResult("Renk eklendi" + color.getName());
	}

	@Override
	public Result remove(Color color) {
		this.colorRepository.remove(color);
		return new SuccessResult("Renk silindi."+color.getName());
	}

	@Override
	public Result update(int id,Color color) {
		int index=0;
		for (Color elements : this.colorRepository.getAll()) {
			if(id==elements.getId()) {
				index=this.colorRepository.getAll().indexOf(elements);
				this.colorRepository.update(index, color);
				return new SuccessResult("Renk Güncellendi");
			}				
		}
		return new ErrorResult("Böyle bir renk yok.");
	}

	@Override
	public DataResult<Color> getById(int id) {
		
		return new SuccessDataResult<Color>(this.colorRepository.getById(id), "Listelendi");
	}

	@Override
	public DataResult<List<Color>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Color>>(this.colorRepository.getAll(), "Renkler listelendi.");
	}



}
