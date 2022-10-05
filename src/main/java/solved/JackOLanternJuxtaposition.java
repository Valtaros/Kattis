//This is a solution for the problem "Jack-O'-Lantern Juxtaposition" from open.kattis.com
//link to problem: https://open.kattis.com/problems/jackolanternjuxtaposition
package main.java.solved;

import java.util.Scanner;

public class JackOLanternJuxtaposition {
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		System.out.println(inputScanner.nextInt() * inputScanner.nextInt() * inputScanner.nextInt());
		//close Scanner
		inputScanner.close();
	}
}
