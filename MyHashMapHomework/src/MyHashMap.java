import java.util.Iterator;

public class MyHashMap<K, V> {
	
	Object[] keys = new Object[0];
	Object[] values = new Object[0];
	
	public MyHashMap() {
	}
	
	public void put(K key, V value) {
		Object[] tempKey = new Object[keys.length];
		Object[] tempValue = new Object[keys.length];
		
		for (int i = 0; i < keys.length; i++) {
			tempKey[i] = keys[i];
			tempValue[i] = values[i];
		}
		
		keys = new Object[keys.length + 1];
		values = new Object[values.length + 1];
		
		for (int i = 0; i < tempKey.length; i++) {
			keys[i] = tempKey[i];
			values[i] = tempValue[i];
		}
		
		keys[keys.length - 1] = key;
		values[values.length - 1] = value;
	}
	
	public void remove(K key) {
		Object[] tempKey = new Object[keys.length];
		Object[] tempValue = new Object[keys.length];
		Object[] dummyKey = new Object[keys.length - 1];
		Object[] dummyValue = new Object[keys.length - 1];
		
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != key){
				tempKey[i] = keys[i];
				tempValue[i] = values[i];
			}
		}
		keys = tempKey;
		values = tempValue;
	}
	
	public Object get(K key) {
		Object result = null;
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] == key) {
				result = values[i];
			}
		}
		return result;
		}
	
	public void clear() {
		keys = new Object[0];
		values = new Object[0];
	}	
}