//This is a solution for the problem "Zamka" from open.kattis.com
//link to problem: https://open.kattis.com/problems/zamka
package solved;

import java.util.Scanner;

public class Zamka {
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		
		int l = inputScanner.nextInt();
		int d = inputScanner.nextInt();
		int x = inputScanner.nextInt();
		
		//close Scanner
		inputScanner.close();
		for(int i = l; i <= d; i++) {
			if(digitSum(i) == x) {
				System.out.println(i);
				break;
			}
		}
		for(int i = d; i >=l; i--) {
			if(digitSum(i) == x) {
				System.out.println(i);
				break;
			}
		}

	}
	
	private static int digitSum(int x) {
		int sum = 0;
		while(x > 9) {
			sum += x % 10;
			x -= x%10;
			x /= 10;
		}
		sum += x;
		return sum;
	}
}
