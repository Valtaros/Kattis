package main.java.solved;
import java.util.Scanner;

public class EpigDanceOff {

	public static void main(String[] args) {
		Scanner input_scanner = new Scanner(System.in);
		
		
		int n = input_scanner.nextInt();
		int m = input_scanner.nextInt();
		input_scanner.nextLine();
		
		int[] columns = new int[m];
		
		for(int i_1 = 0; i_1 < n; i_1++) {
			String next_line = input_scanner.nextLine();
			for(int i_2 = 0; i_2 < m; i_2++) {
				if(next_line.charAt(i_2) == '$') {
					columns[i_2]++;
				}
			}
		}
		input_scanner.close();
		int output = 1;
		for(int i = 0; i < m; i++) {
			if(columns[i] == 0) {
				output++;
			}
		}
		
		System.out.print(output);
		
	}

}
