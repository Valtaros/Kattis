//This is a solution for the problem "Speed Limit" from open.kattis.com
//link to problem: https://open.kattis.com/problems/speedlimit
package solved;
import	java.util.Scanner;

public class SpeedLimit {
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		
		
		int entries;
		while((entries = inputScanner.nextInt()) != -1) {
			int timeElapsedTotal = 0;
			int milesTotal = 0;
			for(int entry = 0; entry < entries; entry++) {
				int milesPerHour = inputScanner.nextInt();
				int timeElapsed = inputScanner.nextInt();
				timeElapsed -= timeElapsedTotal;
				milesTotal += milesPerHour * timeElapsed;
				timeElapsedTotal += timeElapsed;
			}
			System.out.println(milesTotal + " miles");
		}
		
		//close Scanner
		inputScanner.close();
	}
}
