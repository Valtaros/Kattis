//This is a solution for the problem "Chanukah Challenge" from open.kattis.com
//link to problem: https://open.kattis.com/problems/chanukah
package main.java.solved;

import java.util.Scanner;

public class ChanukahChallenge {
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		//read number of cases
		int cases = inputScanner.nextInt();
		//handle each case
		for(int i = 0; i < cases; i++){
			int caseNumber = inputScanner.nextInt();
			int days = inputScanner.nextInt();
			System.out.println(caseNumber + " " + (((days*(days+1)) / 2) + days));
		}
		//close Scanner
		inputScanner.close();
	}
}
