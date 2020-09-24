package solved;

import java.util.Scanner;

public class Billiard
{
public static void main(String[] args) {
	//initialize input scanner
	Scanner	inputScanner = new Scanner(System.in);
	double a = inputScanner.nextDouble();
	double b = inputScanner.nextDouble();
	double s = inputScanner.nextDouble();
	double m = inputScanner.nextDouble();
	double n = inputScanner.nextDouble();
	while
		(
			a != 0 &&
			b != 0 &&
			s != 0 &&
			m != 0 &&
			n != 0
		)
	{
		double degree = Math.round( ( ( 180 * Math.atan( (n * b) / (m * a) ) ) / Math.PI ) * 100.0) / 100.0;
		double speed = Math.round( ( ( Math.sqrt( (m * m * a * a) + (n * n * b * b) ) ) / s ) * 100.0) / 100.0;
		System.out.format("%.2f ", degree);
		System.out.format("%.2f\n", speed);
		a = inputScanner.nextDouble();
		b = inputScanner.nextDouble();
		s = inputScanner.nextDouble();
		m = inputScanner.nextDouble();
		n = inputScanner.nextDouble();
		
	}
	//close Scanner
	inputScanner.close();
}
}
