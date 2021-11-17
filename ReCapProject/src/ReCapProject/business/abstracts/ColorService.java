package ReCapProject.business.abstracts;

import java.util.List;

import ReCapProject.core.utilities.results.DataResult;
import ReCapProject.core.utilities.results.Result;
import ReCapProject.entities.concretes.Color;

public interface ColorService {
	Result add(Color color);
	Result remove(Color color);
	Result update(int id,Color color);
	DataResult<Color> getById(int id);
	DataResult<List<Color>> getAll();
}
