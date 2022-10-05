//This is a solution for the problem "Add Two Numbers" from open.kattis.com
//link to problem: https://open.kattis.com/problems/addtwonumbers
package main.java.wip;

import java.util.Scanner;

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		System.out.println((inputScanner.nextInt() + inputScanner.nextInt()));
		//close Scanner
		inputScanner.close();
	}
}
