
public class Main {

	public static void main(String[] args) {
		
		ProductManager productmanager=new ProductManager(new DbLoger());
		
		productmanager.save();

	}

}
