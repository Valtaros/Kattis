import java.util.Scanner;

public class Geppetto {

	public static void main(String[] args) {
		Scanner input_scanner = new Scanner(System.in);
		
		int number_of_ingredients	= input_scanner.nextInt();
		int number_of_exclusions	= input_scanner.nextInt();
		
		boolean[][] exclusions 		= new boolean[number_of_ingredients][number_of_ingredients];
		
		input_scanner.close();
		
	}

}
