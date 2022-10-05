//This is a solution for the problem "Sum Squared Digits Function" from open.kattis.com
//link to problem: https://open.kattis.com/problems/sumsquareddigits
package main.java.solved;
import	java.util.Scanner;

public class SumSquaredDigitsFunction{
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		
		int dataSets = inputScanner.nextInt();
		for(int i = 0; i < dataSets; i++) {
			int dataSet = inputScanner.nextInt();
			long base = inputScanner.nextLong();
			long n = inputScanner.nextLong();
			long sum = 0;
			long basepower = 1;
			while(basepower <= n) {
				basepower *= base;
			}
			basepower /= base;
			while(basepower != 0) {
				long a = n / basepower;
				sum += a*a;
				n -= a*basepower;
				basepower /= base;
			}
			System.out.println(dataSet + " " + sum);
		}
		
		//close Scanner
		inputScanner.close();
	}
}
