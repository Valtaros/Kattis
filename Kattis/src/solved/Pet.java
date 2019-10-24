package solved;
import java.util.Scanner;

public class Pet {

	public static void main(String[] args) {
		Scanner input_scanner = new Scanner(System.in);
		
		int winner_number = 0;
		int winner_points = 0;
		
		for(int i = 1; i < 6 ; i++) {
			int points = input_scanner.nextInt() + input_scanner.nextInt() + input_scanner.nextInt() + input_scanner.nextInt();
			if (points > winner_points) {
				winner_number = i;
				winner_points = points;
			}
		}
		
		input_scanner.close();
		
		System.out.print(winner_number + " " + winner_points);
	}

}
