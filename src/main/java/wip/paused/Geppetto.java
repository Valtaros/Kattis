package main.java.wip.paused;
import java.util.Scanner;

public class Geppetto {

	public static void main(String[] args) {
		
		//	initialize scanner
		Scanner input_scanner = new Scanner(System.in);
		
		//	initialize variables n(total number of ingredients) and m(number of exclusions)
		int n	= input_scanner.nextInt();
		int m	= input_scanner.nextInt();
		
		//	initialize table for exclusions
		boolean[][] exclusions = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				exclusions[i][j] = false;
			}
		}
		
		//	read exclusions
		for(int i = 0; i < m; i++) {
			int first	= input_scanner.nextInt();	
			int second	= input_scanner.nextInt();
			exclusions[first][second] = true;
			exclusions[second][first] = true;
			
		}
		
		
		//	close scanner (no more input expected)
		input_scanner.close();
		
		
		
	}

}
