//This is a solution for the problem "Batter Up" from open.kattis.com
//link to problem: https://open.kattis.com/problems/batterup
package solved;

import java.util.Scanner;

public class BatterUp {
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		int atBats = inputScanner.nextInt();
		double bats = 0;
		double sum = 0;
		for(int i = 0; i < atBats; i++) {
			double nextBat = inputScanner.nextDouble();
			if(nextBat != -1) {
				bats++;
				sum += nextBat;
			}
		}
		System.out.print(sum/bats);
		
		//close Scanner
		inputScanner.close();
	}
}
