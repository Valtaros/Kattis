package main.java.solved;
import java.util.Scanner;

public class DiceCup {

	public static void main(String[] args) {
		//initialize input scanner
		Scanner inputScanner = new Scanner(System.in);
		//get input
		int dice1 = inputScanner.nextInt();
		int dice2 = inputScanner.nextInt();
		//ensure that dice1 is the "smaller" dice, if not equal
		if(dice1 > dice2) {
			//switch dice if necessary
			int temp = dice1;
			dice1 = dice2;
			dice2 = temp;
		}
		//create output
		for(int i = dice1; i <= dice2; i++) {
			System.out.println(i+1);
		}
		
	}

}
