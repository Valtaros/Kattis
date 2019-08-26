import java.util.Scanner;

public class MeowFactor {

	public static void main(String[] args) {
		Scanner input_scanner = new Scanner(System.in);
		
		long input = input_scanner.nextLong();
		input_scanner.close();
		
		long meow_factor = 1;
		long factor_to_check = 2;
		long power_of_factor = 0;
		do {
			power_of_factor = (long)Math.pow(factor_to_check, 9);
			long remainder = input % power_of_factor;
			if(remainder == 0) {
				meow_factor = factor_to_check;
			}
			factor_to_check++;
		}while(factor_to_check < 128);
		
		System.out.print(meow_factor);
	}

}
