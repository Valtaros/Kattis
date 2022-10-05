package main.java.solved;
import java.util.Scanner;

public class PieceOfCake {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		
		int size = inputScanner.nextInt();
		int cut1 = inputScanner.nextInt();
		int cut2 = inputScanner.nextInt();
		
		inputScanner.close();
		if(size - cut1 > cut1) {
			cut1 = size - cut1;
		}
		if(size - cut2 > cut2) {
			cut2 = size - cut2;
		}
		
		System.out.print(cut1*cut2*4);
	}
	
}
