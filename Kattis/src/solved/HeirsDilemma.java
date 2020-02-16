package solved;

import java.util.Scanner;

public class HeirsDilemma {

	public static void main(String[] args) {
		//initialize input Scanner
		Scanner inputScanner = new Scanner(System.in);
		//get input 
		int minimumInput = inputScanner.nextInt();
		int maximumInput = inputScanner.nextInt();
		//close input Scanner(no longer required)
		inputScanner.close();
		//initialize counter for possible combinations
		int countOfPossibilities = 0;
		//check each value from minimumInput to maximumInput
		for(int nextInt = minimumInput; nextInt <= maximumInput; nextInt++) {
			//initialize flag for check
			boolean isPossibleCombination = true;
			//create array of digits for easier comparison
			int[] digits = new int[6];
			digits[0] = nextInt / 100000;
			digits[1] = (nextInt - (digits[0] * 100000)) / 10000;
			digits[2] = (nextInt - (digits[0] * 100000) - (digits[1] * 10000)) / 1000;
			digits[3] = (nextInt - (digits[0] * 100000) - (digits[1] * 10000) - (digits[2] * 1000)) / 100;
			digits[4] = (nextInt - (digits[0] * 100000) - (digits[1] * 10000) - (digits[2] * 1000) - (digits[3] * 100)) / 10;
			digits[5] = nextInt - (digits[0] * 100000) - (digits[1] * 10000) - (digits[2] * 1000) - (digits[3] * 100) - (digits[4] * 10);
			//check for zeros
			for(int i = 0; i < 6; i++) {
				if(digits[i] == 0) {
					isPossibleCombination = false;
				}
			}
			//check digits
			for(int i = 0; i < 6 && isPossibleCombination; i++) {
				//check if nextInt can be divided by digit
				if(nextInt%digits[i] != 0) {
					isPossibleCombination = false;
				}
				//check if other digits are equal
				for(int j = i + 1; j < 6 && isPossibleCombination; j++) {
					if(digits[i] == digits[j]) {
						isPossibleCombination = false;
					}
				}
			}
			if(isPossibleCombination) {
				countOfPossibilities++;
			}
		}
		//return result
		System.out.print(countOfPossibilities);

	}

}
