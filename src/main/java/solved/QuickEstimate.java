//This is a solution for the problem "Quick Estimate" from open.kattis.com
//link to problem: https://open.kattis.com/problems/quickestimate
package main.java.solved;

import java.util.Scanner;

public class QuickEstimate {
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		int testCases = inputScanner.nextInt();
		for(int i = 0; i < testCases; i++) {
			System.out.println(inputScanner.next().length());
		}
		//close Scanner
		inputScanner.close();
	}
}
