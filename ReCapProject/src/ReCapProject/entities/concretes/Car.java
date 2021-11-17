package ReCapProject.entities.concretes;

public class Car {
	private int id;
	private int brandId;
	private int colorId;
	private int modelYear;
	private double dailyPrice;
	private String description;
	
	public Car() {

	}

	public Car(int id, int brandId, int colorId, int modelYear, double dailyPrice, String description) {
		this.id = id;
		this.brandId = brandId;
		this.colorId = colorId;
		this.modelYear = modelYear;
		this.dailyPrice = dailyPrice;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
