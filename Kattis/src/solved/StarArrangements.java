//This is a solution for the problem "Star Arrangements" from open.kattis.com
//link to problem: https://open.kattis.com/problems/stararrangements
package solved;
import	java.util.Scanner;

public class StarArrangements{
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		//get input
		int input = inputScanner.nextInt();
		//close Scanner
		inputScanner.close();
		System.out.println(input + ":");
		for(int row1 = 2; row1 <= (input/2)+1; row1++) {
			//check for second row smaller
			int row2 = row1-1;
			int helper = input % (row1 + row2);
			if(helper == 0 || helper == row1) {
				System.out.println(row1 + "," + row2);
			}
			helper = input % row1;
			if(helper == 0) {
				System.out.println(row1 +"," + row1);
			}
		}
	}
}
