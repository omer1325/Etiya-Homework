package ReCapProject;


import ReCapProject.business.abstracts.BrandService;
import ReCapProject.business.abstracts.CarService;
import ReCapProject.business.abstracts.ColorService;
import ReCapProject.business.concretes.BrandManager;
import ReCapProject.business.concretes.CarManager;
import ReCapProject.business.concretes.ColorManager;
import ReCapProject.dataAccess.concretes.BrandDao;
import ReCapProject.dataAccess.concretes.CarDao;
import ReCapProject.dataAccess.concretes.ColorDao;
import ReCapProject.entities.concretes.Brand;
import ReCapProject.entities.concretes.Car;
import ReCapProject.entities.concretes.Color;

public class Main {

	public static void main(String[] args) {
		
	
		ColorService colorService= new ColorManager(new ColorDao());
		
		colorService.add(new Color(1,"Mavi"));
		colorService.add(new Color(2,"Kırmızı"));
		colorService.add(new Color(3,"Pembe"));
		
		Color c1=new Color();
		c1.setId(4);
		c1.setName("Turuncu");
		colorService.add(c1);
		//colorService.getById(2);
		colorService.remove(colorService.getById(2).getData());
		//colorService.remove(colorService.getById(2).getData());
		colorService.update(3, new Color(3,"Siyah"));
		
		for (Color colors : colorService.getAll().getData()) {
			System.out.println(colors.getName());
		}
		
		System.out.println("---------------");
		
		CarService carService = new CarManager(new CarDao());
		
		carService.add(new Car(1,1,1,2020,505000,"porsche"));
		carService.add(new Car(2,2,2,2020,505200,"absd"));
		carService.add(new Car(3,3,3,2020,56,"QWE"));
		carService.remove(carService.getById(3).getData());
	//	carService.update(2, new Car(2,3,3,2020,505500,"qwe"));
		for (Car car : carService.getAll().getData()) {
			System.out.println(car.getDescription());

		}
		
		System.out.println("------------------------");
		
		BrandService brandService = new BrandManager(new BrandDao());
		
		brandService.add(new Brand(1,"Ford"));
		brandService.add(new Brand(2,"BMW"));
		brandService.add(new Brand(3,"Mercedes"));
		
	//	brandService.remove(brandService.getById(2).getData());
		brandService.update(2, new Brand(2,"WOLSSSSSSSSSSSSSSSSSSSSSS"));
		
		for (Brand brand : brandService.getAll().getData()) {
			System.out.println(brand.getName());
		}
		
				
	}

}
