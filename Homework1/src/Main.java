import java.util.Random;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Oynanmak istenen kolon adedi: ");
		Scanner scanner = new Scanner(System.in);
		
		int kolonSayisi = scanner.nextInt();
		int kolon[][] = new int[kolonSayisi][6];
		
		for (int i = 0; i < kolonSayisi; i++) {
			for (int j = 0; j < 6; j++) {
				Random rnd = new Random();
				int sayi = 1 + rnd.nextInt(49);
				if (sayi != kolon[i][j]) { 
					kolon[i][j] = sayi;
				}
			}
		}
		for (int i = 0; i < kolonSayisi; i++) {
			System.out.println("");
			for (int j = 0; j < 6; j++) {
				System.out.print(kolon[i][j] + "  ");
			}
		}
	}
}
