
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry = { 25, 50, 75, 125, 100 };
		int temp;

		for (int i = 0; i < arry.length; i++) {
			for (int j = i + 1; j < arry.length; j++) {
				if (arry[j] > arry[i]) {
					temp = arry[i];
					arry[i] = arry[j];
					arry[j] = temp;
				}
			}
		}
		for (int i = 0; i < arry.length; i++) {
			System.out.println(arry[i]);
		}
	}
}


