package main.java.solved;
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
			power_of_factor = factor_to_check * factor_to_check * factor_to_check * factor_to_check * factor_to_check * factor_to_check * factor_to_check * factor_to_check * factor_to_check;
			long remainder = input % power_of_factor;
			if(remainder == 0) {
				meow_factor = meow_factor * factor_to_check;
				input = input / power_of_factor;
			}
			else {
				factor_to_check++;
			}
		}while(factor_to_check < 128);
		
		System.out.print(meow_factor);
	}
}

/*
2. VERSION - TIME LIMIT EXCEEDED
import java.util.ArrayList;
import java.util.Scanner;

public class MeowFactor {

	public static void main(String[] args) {
		Scanner 			input_scanner = new Scanner(System.in);
		
		long 				number = input_scanner.nextLong();
		input_scanner.close();
		
		ArrayList<Long>	factors = new ArrayList<Long>();
		ArrayList<Integer>	factor_counts = new ArrayList<Integer>();
		
		int					different_factors = 0;
		long				current_factor = 2;
		boolean 			in_list = false;
		
		while(current_factor == 2) {
			if(number % current_factor == 0) {
				if(in_list) {
					int temp = factor_counts.get(different_factors - 1) + 1;
					factor_counts.remove(different_factors - 1);
					factor_counts.add(temp);
				}
				else {
					factors.add(current_factor);
					factor_counts.add(1);
					in_list = true;
					different_factors++;
				}
				number = number / current_factor;
			}
			else {
				in_list = false;
				current_factor++;
			}
		}
		while(current_factor <= number) {
			if(number % current_factor == 0) {
				if(in_list) {
					int temp = factor_counts.get(different_factors - 1) + 1;
					factor_counts.remove(different_factors - 1);
					factor_counts.add(temp);
				}
				else {
					factors.add(current_factor);
					factor_counts.add(1);
					in_list = true;
					different_factors++;
				}
				number = number / current_factor;
			}
			else {
				in_list = false;
				current_factor++;
				current_factor++;
			}
		}
		
		long meow_factor = 1;
		
		for(int i = 0; i < factors.size(); i++) {
			if(factor_counts.get(i) > 8){
				meow_factor = meow_factor * factors.get(i);
				int temp = factor_counts.get(i) - 9;
				factor_counts.remove(i);
				factor_counts.add(i--, temp);
			}
		}
		
		System.out.print(meow_factor);
	}
}
*/