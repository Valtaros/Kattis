package main.java.solved;
import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		
		int x = inputScanner.nextInt();
		int y = inputScanner.nextInt();
		int n = inputScanner.nextInt();
		
		inputScanner.close();
		
		for(int i = 1; i <= n; i++) {
			if(i % x == 0 || i % y == 0) {
				if(i % x == 0) {
					System.out.print("Fizz");
				}
				if(i % y == 0) {
					System.out.print("Buzz");
				}
			}else {
				System.out.print(i);
			}
			System.out.print("\n");
		}
	}

}
