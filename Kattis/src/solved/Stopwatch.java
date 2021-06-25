//This is a solution for the problem "Stopwatch" from open.kattis.com
//link to problem: https://open.kattis.com/problems/stopwatch
package solved;
import	java.util.Scanner;

public class Stopwatch{
	
	public static void main(String[] args) {
		
	    //initialize input scanner
	    Scanner inputScanner = new Scanner(System.in);
	    
	    int numberOfPresses = inputScanner.nextInt();
	    if(numberOfPresses % 2 != 0) {
		System.out.println("still running");
	    }else {
		int sum = 0;
		for(int i = 0; i < numberOfPresses; i += 2) {
		    int startTimer = inputScanner.nextInt();
		    int endTimer = inputScanner.nextInt();
		    sum += (endTimer - startTimer);
		}
		System.out.println(sum);
	    }
	    //close Scanner
	    inputScanner.close();
	}
}
