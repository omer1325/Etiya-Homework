
public class Main {

	public static void main(String[] args) {
		
		MyHashMap<String,String> hashMap = new MyHashMap<String,String>();
		
		hashMap.put("5", "ömer ");
		hashMap.put("15", "hasan ");
		hashMap.put("25", "yasir ");
		hashMap.put("35", "asude ");
		System.out.println( hashMap.get("5"));
		//hashMap.remove("5");
		//hashMap.clear();
	}

}
