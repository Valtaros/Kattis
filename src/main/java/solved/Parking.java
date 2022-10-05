//This is a solution for the problem "Parking" from open.kattis.com
//link to problem: https://open.kattis.com/problems/parking2
package main.java.solved;
import	java.util.Scanner;

public class Parking
{
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		
		int numberOfTestCases = inputScanner.nextInt();
		for
		(
			int i = 0;
			i < numberOfTestCases;
			i++
		)
		{
			int numberOfShops = inputScanner.nextInt() - 1;
			int max = inputScanner.nextInt();
			int min = max;
			for
			(
				int j = 0;
				j < numberOfShops;
				j++
			)
			{
				int nextShop = inputScanner.nextInt();
				if(nextShop < min) {
					min = nextShop;
				}
				if(nextShop > max) {
					max = nextShop;
				}
			}
			System.out.println((max - min)*2);
		}
		
		//close Scanner
		inputScanner.close();
	}
}
