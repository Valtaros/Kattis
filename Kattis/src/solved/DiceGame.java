//This is a solution for the problem "Dice Game" from open.kattis.com
//link to problem: https://open.kattis.com/problems/dicegame
package solved;

import java.util.Scanner;

public class DiceGame {

	public static void main(String[] args) {
		//initialize Scanner
		Scanner inputScanner = new Scanner(System.in);
		//initialize array for values
		double[] diceValues = new double[8];
		//read values
		for(int i = 0; i < 8; i++) {
			diceValues[i] = inputScanner.nextInt();
		}
		//close Scanner
		inputScanner.close();
		//determine average dicerolls
		double gunnar = (diceValues[0] + diceValues[1] + diceValues[2] + diceValues[3])/2;
		double emma = (diceValues[4] + diceValues[5] + diceValues[6] + diceValues[7])/2;
		//return result
		if(gunnar > emma) {
			System.out.println("Gunnar");
		}else if(gunnar < emma) {
			System.out.println("Emma");
		}else {
			System.out.println("Tie");
		}
	}
}
