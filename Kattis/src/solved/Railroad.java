//This is a solution for the problem "Railroad" from open.kattis.com
//link to problem: https://open.kattis.com/problems/railroad2
package solved;

import java.util.Scanner;

public class Railroad {
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		
		inputScanner.nextInt();
		if(inputScanner.nextInt() % 2 == 0) {
			System.out.print("possible");
		}else {
			System.out.print("impossible");
		}
		//close Scanner
		inputScanner.close();
	}

}
