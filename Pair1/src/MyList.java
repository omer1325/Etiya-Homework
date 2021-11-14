public class MyList<T> {

	Object[] array;

	public MyList() {
		this.array = new Object[0];
	}

	public void add(T item) {
		Object[] dummy = new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			dummy[i] = array[i];
		}
		this.array = new Object[this.array.length + 1];

		for (int i = 0; i < dummy.length; i++) {
			this.array[i] = dummy[i];
		}
		this.array[this.array.length - 1] = item;
	}

	public boolean contains(T item) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == item) {
				return true;
			}
		}
		return false;
	}

	public void remove(Object item) {
		int count = 0;
		for (Object string : array) {
			if (string == item) {
				count++;
			}
		}
		Object[] dummy = new Object[array.length - count];
		for (int i = 0; i < dummy.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (this.array[j] != item) {
					dummy[i] = array[j];
					break;
				}
			}
		}
		this.array = new String[dummy.length];
		for (int i = 0; i < dummy.length; i++) {
			this.array[i] = dummy[i];
		}
	}

	public void remove(int index) {
		Object[] tempArray = new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			tempArray[i] = array[i];
		}
		array = new Object[array.length - 1];
		int value = 0;
		for (int i = 0; i < array.length + 1; i++) {
			if (i == index) {
				continue;
			} else {
				array[value] = tempArray[i];
			}
			value++;
		}
	}

	public void list() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
