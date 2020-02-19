package wip;

//current implementation seems to be working, but time limit of 1 second is not kept for at least one test case

import java.util.ArrayList;
import java.util.Scanner;

public class ZeroOneSequences {

	public static void main(String[] args) {
		//initialize input scanner
		Scanner inputScanner = new Scanner(System.in);
		//initialize ArrayList representing the sequence
		ArrayList<Character> digits = new ArrayList<Character>();
		//get input
		String input = inputScanner.next();
		//close input scanner(no longer required)
		inputScanner.close();
		//populate list
		for(int i = 0; i < input.length(); i++) {
			digits.add(input.charAt(i));
		}
		long result = replaceMissingDigits(digits)%1000000007;
		System.out.print(result);
	}

	private static long replaceMissingDigits(ArrayList<Character> digits) {
		long result = 0;
		if(digits.contains('?')) {
			int index = digits.indexOf('?');
			digits.set(index, '0');
			result = replaceMissingDigits(digits);
			digits.set(index, '1');
			result = result + replaceMissingDigits(digits);
			digits.set(index, '?');
		}else {
			result = calculateInversionCount(digits);
		}
		
		return result;
	}
	
	private static long calculateInversionCount(ArrayList<Character> digits) {
		long result = 0;
		int countOfCheckedZeros = 0;
		for(int index = 0; index < digits.size(); index++) {
			if(digits.get(index) == '0') {
				result += index - countOfCheckedZeros;
				countOfCheckedZeros++;
			}
		}
		
		return result;
	}
}
