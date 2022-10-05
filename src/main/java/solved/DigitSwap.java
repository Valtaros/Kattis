//This is a solution for the problem "Digit Swap" from open.kattis.com
//link to problem: https://open.kattis.com/problems/digitswap
package main.java.solved;

import java.util.Scanner;

public class DigitSwap {
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		//read input
		String input = inputScanner.next();
		//close Scanner
		inputScanner.close();
		String[] digits = input.split("");
		System.out.println(digits[1] + digits[0]);
	}
}
