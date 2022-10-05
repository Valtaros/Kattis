//This is a solution for the problem "Roaming Romans" from open.kattis.com
//link to problem: https://open.kattis.com/problems/romans
package main.java.solved;

import java.util.Scanner;

public class RoamingRomans {

	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		double input = Double.parseDouble(inputScanner.next());
		//close Scanner
		inputScanner.close();
		double resultDouble = input * 1000 * 5280 / 4854 + 0.5;
		int resultInt = (int) resultDouble;
		System.out.print(resultInt);
		
	}
}
