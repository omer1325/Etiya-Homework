public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arry = {5, 9, 2, 5, 8, 3, 4, 8, 1, 7, 6, 9, 5, 6}; //14	
		int[] arry2 = new int[arry.length];
		
		for (int i = 0; i < arry.length; i++) {
			arry2[arry[i]-1] = arry2[arry[i]-1] + 1;
			if (arry2[arry[i]-1] > 1) {
				arry[i] = 0;
			}
		}
		
		for (int i = 0; i < arry.length; i++) {
			if (arry[i] != 0 ) {
				System.out.println(arry[i] + " ");
			}
		}
		
	}
}