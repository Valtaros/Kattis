package solved;
import java.util.Scanner;
import java.util.TreeSet;

public class JollyJumpers {
	public static void main(String[] args) {
		Scanner input_scanner = new Scanner(System.in);
		
		while(input_scanner.hasNext()) {
			int n = input_scanner.nextInt();
			
			if(n == 1) {
				input_scanner.nextInt();
				System.out.println("Jolly");
				
			}
			else {
				TreeSet<Integer> remaining_differences = new TreeSet<Integer>();
				for(int i = 1; i < n; i++) {
					remaining_differences.add(i);
				}
				
				int last_number = input_scanner.nextInt();
				for(int i = 1; i < n; i++) {
					int next_number = input_scanner.nextInt();
					remaining_differences.remove(next_number - last_number);
					remaining_differences.remove(last_number - next_number);
					last_number = next_number;
				}
				
				if(remaining_differences.isEmpty()) {
					System.out.println("Jolly");
				}
				else {
					System.out.println("Not jolly");
				}
			}
		}
	}
}
