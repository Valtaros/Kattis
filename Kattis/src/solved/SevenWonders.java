//This is a solution for the problem "Seven Wonders" from open.kattis.com
//link to problem: https://open.kattis.com/problems/sevenwonders
package solved;

import java.util.Scanner;

public class SevenWonders {

	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		
		String input = inputScanner.next();
		
		//close Scanner
		inputScanner.close();
		int t = 0;
		int c = 0;
		int g = 0;
		for(int i = 0; i < input.length(); i++) {
			switch(input.charAt(i)) {
			case 'T' : t++; break;
			case 'C' : c++; break;
			case 'G' : g++; break;
			}
		}
		
		int result = (t * t) + (c * c) + (g * g) + (7 * Math.min(t, Math.min(c, g)));
		System.out.print(result);
		
	}
}
