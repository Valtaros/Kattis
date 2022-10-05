//This is a solution for the problem "Finding An A" from open.kattis.com
//link to problem: https://open.kattis.com/problems/findingana
package main.java.solved;

import java.util.Scanner;

public class FindingAnA {
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		//read input
		String input = inputScanner.nextLine();
		//close Scanner
		inputScanner.close();

		System.out.println(input.substring(input.indexOf("a")));
	}
}
