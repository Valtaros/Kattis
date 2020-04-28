//This is a solution for the problem "Trik" from open.kattis.com
//link to problem: https://open.kattis.com/problems/trik
package solved;
import	java.util.Scanner;

public class Trik{
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		//get input
		String input = inputScanner.next();
		//close Scanner
		inputScanner.close();
		//setup cups
		boolean cup1 = true;
		boolean cup2 = false;
		boolean cup3 = false;
		for(int i = 0; i < input.length(); i++) {
			switch(input.charAt(i)) {
			case 'A':
				if(cup1 || cup2) {
					cup1 = !cup1;
					cup2 = !cup2;
				}
				break;
			case 'B':
				if(cup2 || cup3) {
					cup2 = !cup2;
					cup3 = !cup3;
				}
				break;
			case 'C':
				if(cup1 || cup3) {
					cup1 = !cup1;
					cup3 = !cup3;
				}
				break;
			}
		}
		if(cup1) {
			System.out.print(1);
		}
		if(cup2) {
			System.out.print(2);
		}
		if(cup3) {
			System.out.print(3);
		}
		
	}
}
