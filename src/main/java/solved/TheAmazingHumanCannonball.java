//This is a solution for the problem "The Amazing Human Cannonball" from open.kattis.com
//link to problem: https://open.kattis.com/problems/humancannonball2
package main.java.solved;
import	java.util.Scanner;

public class TheAmazingHumanCannonball{
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		int testCases = inputScanner.nextInt();
		
		for(int i = 0; i < testCases; i++) {
			double v0 = Double.parseDouble(inputScanner.next());
			double theta = Double.parseDouble(inputScanner.next()) / 180 * Math.PI;
			double x1 = Double.parseDouble(inputScanner.next());
			double h1 = Double.parseDouble(inputScanner.next());
			double h2 = Double.parseDouble(inputScanner.next());
			
			double t = x1 / (v0 * Math.cos(theta));
			double y = (v0 * t * Math.sin(theta)) - (0.5 * 9.81 * t * t);
			if(y >= (h1 + 1) && y <= (h2 - 1)) {
				System.out.println("Safe");
			}else {
				System.out.println("Not Safe");
			}
		}
		
		//close Scanner
		inputScanner.close();
	}
}
