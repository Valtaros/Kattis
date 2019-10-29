import java.util.Scanner;

public class Geppetto {

	public static void main(String[] args) {
		Scanner input_scanner = new Scanner(System.in);
		
		int number_of_ingredients	= input_scanner.nextInt();
		int number_of_exclusions	= input_scanner.nextInt();
		
		boolean[][] exclusions 		= new boolean[number_of_ingredients][number_of_ingredients];
		
		for(int i = 0; i < number_of_ingredients; i++) {
			for(int j = 0; j < number_of_ingredients; j++) {
				exclusions[i][j] = false;
			}
		}
		
		for(int i = 0; i < number_of_exclusions; i++) {
			
		}
		
		input_scanner.close();
		
	}

}
