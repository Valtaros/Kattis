//This is a solution for the problem "Datum" from open.kattis.com
//link to problem: https://open.kattis.com/problems/datum

package solved;

import java.util.*;

public class Datum {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		int dayOfMonth = inputScanner.nextInt();
		int month = inputScanner.nextInt();
		inputScanner.close();
		
		int dayOfWeek = 3;
		
		switch(month) {
		case 12:	dayOfWeek = dayOfWeek + 30;
		case 11:	dayOfWeek = dayOfWeek + 31;
		case 10:	dayOfWeek = dayOfWeek + 30;
		case 9:		dayOfWeek = dayOfWeek + 31;
		case 8:		dayOfWeek = dayOfWeek + 31;
		case 7:		dayOfWeek = dayOfWeek + 30;
		case 6:		dayOfWeek = dayOfWeek + 31;
		case 5:		dayOfWeek = dayOfWeek + 30;
		case 4:		dayOfWeek = dayOfWeek + 31;
		case 3:		dayOfWeek = dayOfWeek + 28;
		case 2:		dayOfWeek = dayOfWeek + 31;
		case 1:		dayOfWeek = dayOfWeek + dayOfMonth;
		}
		
		switch(dayOfWeek % 7) {
		case 0:	System.out.println("Sunday"); break;
		case 1:	System.out.println("Monday"); break;
		case 2:	System.out.println("Tuesday"); break;
		case 3:	System.out.println("Wednesday"); break;
		case 4:	System.out.println("Thursday"); break;
		case 5:	System.out.println("Friday"); break;
		case 6:	System.out.println("Saturday"); break;
		
		}
	}
}
