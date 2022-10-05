package main.java.solved;
import java.util.Scanner;

public class HeartRate {

	public static void main(String[] args) {
		Scanner input_scanner = new Scanner(System.in);
		
		int n = input_scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			double b = input_scanner.nextDouble();
			double p = input_scanner.nextDouble();
			double bpm = 60 * b / p;
			double abpm_max = 60 / ( p / ( b + 1 ) );
			double abpm_min = 60 / ( p / ( b - 1 ) );
			
			System.out.printf("%.4f %.4f %.4f\n", abpm_min, bpm, abpm_max);
		}
		
		input_scanner.close();
	}
}
