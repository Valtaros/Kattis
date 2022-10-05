//This is a solution for the problem "Triangle Area" from open.kattis.com
//link to problem: https://open.kattis.com/problems/triarea
package main.java.wip;

import java.util.Scanner;

public class TriangleArea {
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		//read input
		int height = inputScanner.nextInt();
		int base = inputScanner.nextInt();
		//close Scanner
		inputScanner.close();
		//print result
		System.out.println((double) height * base / 2);
	}
}
