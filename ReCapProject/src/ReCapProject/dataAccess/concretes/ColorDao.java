package ReCapProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ReCapProject.dataAccess.abstracts.ColorRepository;
import ReCapProject.entities.concretes.Color;

public class ColorDao implements ColorRepository{

	
	List<Color> colors;
	public ColorDao() {
		colors=new ArrayList<Color>();
	}
	
	@Override
	public void add(Color entity) {

		colors.add(entity);
	}

	@Override
	public void remove(Color entity) {
		colors.remove(entity);
		
	}

	@Override
	public void update(int id,Color entity) {
		
		colors.set(id, entity);
		
	}

	@Override
	public Color getById(int id) {
			
			//System.out.println(colors.get(id-1).getName()+ " - id: " + colors.get(id-1).getId());
			return colors.get(id-1);
	}

	@Override
	public List<Color> getAll() {
		// TODO Auto-generated method stub
		return colors;
	}

}
