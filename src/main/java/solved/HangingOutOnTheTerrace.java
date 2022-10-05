//This is a solution for the problem "Hanging Out on the Terrace" from open.kattis.com
//link to problem: https://open.kattis.com/problems/hangingout
package main.java.solved;

import java.util.Scanner;

public class HangingOutOnTheTerrace {

	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
	
		int limit = inputScanner.nextInt();
		int events = inputScanner.nextInt();
		int currentPeople = 0;
		int dismissedGroups = 0;
		
		for(int i = 0; i < events; i++) {
			String event = inputScanner.next();
			int people = inputScanner.nextInt();
			if(event.equals("enter")) {
				if(currentPeople + people > limit) {
					dismissedGroups++;
				}else {
					currentPeople += people;
				}
			}else {
				currentPeople -= people;
			}
		}
		//close Scanner
		inputScanner.close();
		
		System.out.print(dismissedGroups);
	}
}
