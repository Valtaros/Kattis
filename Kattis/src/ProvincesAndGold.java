import java.util.Scanner;

public class ProvincesAndGold {

	public static void main(String[] args) {
		Scanner input_scanner = new Scanner(System.in);
		
		int buying_power = (3 * input_scanner.nextInt()) + (2 * input_scanner.nextInt()) + input_scanner.nextInt();
		
		input_scanner.close();
		
		switch(buying_power) {
		case	0	:	 
		case	1	:	System.out.print("Copper"); break;
		case	2	:	System.out.print("Estate or Copper"); break;
		case	3	:
		case	4	:	System.out.print("Estate or Silver"); break;
		case	5	:	System.out.print("Duchy or Silver"); break;
		case	6	:
		case	7	:	System.out.print("Duchy or Gold"); break;
		default		:	System.out.print("Province or Gold"); break;
		}
	}

}
