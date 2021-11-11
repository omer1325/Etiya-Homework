import java.util.Arrays;
import java.util.Iterator;

public class MyList {
	
	String[] array;

	public MyList(int capacity) {
		this.array = new String[capacity];						
	}

	public void add(String value) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length -1 ] = value;
	}
	
	public void list() {
		for (String item : array) {
			System.out.println(item);
		}
	}
	
	public boolean contains(String value) {		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return true;
			}
		}
		return false ;
	}
	
	public void remove(int index) {
		String[] tempArray = array;
		array = new String[array.length - 1];
		
		for (int i = 0; i < array.length; i++) {
			if(i == index) {
				array[i] = tempArray[i + 1];
			}else if(i > index) {
				array[i] = tempArray[i + 1];
			}else {
				array[i] = tempArray[i];
			}
		}
	}
	
	public void remove(String value) {
		String[] newArray = new String[array.length];
		
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		
		for (int i = 0; i < array.length; i++) {
			if (newArray[i] == value) {
				continue;
			}else {
				newArray[i] = array[i];
			}
		}
	}
	
	
}
