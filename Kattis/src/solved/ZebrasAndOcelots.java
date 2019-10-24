package solved;
import java.util.Scanner;

public class ZebrasAndOcelots {

	public static void main(String[] args) {
		Scanner input_scanner = new Scanner(System.in);
		
		int n = input_scanner.nextInt();
		input_scanner.nextLine();
		
		long bell_rings = 0;
		
		for(int i = n - 1; i >= 0; i--) {
			String next = input_scanner.nextLine();
			if(next.equals("O")) {
				bell_rings = bell_rings + (1L << i);
			}
		}
		
		input_scanner.close();
		
		System.out.print(bell_rings);
	}

}
