//This is a solution for the problem "Which is Greater?" from open.kattis.com
//link to problem: https://open.kattis.com/problems/whichisgreater
package main.java.solved;

import java.util.Scanner;

public class WhichIsGreater {
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		//read input
		int inputA = inputScanner.nextInt();
		int inputB = inputScanner.nextInt();
		//close Scanner
		inputScanner.close();
		System.out.println(inputA > inputB ? 1 : 0);
	}
}
