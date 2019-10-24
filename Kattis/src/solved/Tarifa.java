package solved;
import java.util.Scanner;

public class Tarifa {

	public static void main(String[] args) {
		
	//	initialize input scanner
		Scanner input_scanner	= new Scanner(System.in);
		
	//	initialize starting variables
		
		//	x = megabytes per month
		int x 			= input_scanner.nextInt();	
		
		//	n = months
		int n				= input_scanner.nextInt();
		
	//	read data usage of n months
		//	initialize sum of usage p
		int p = 0;	 
		
		// sum used data over n months
		for(int i = 0; i < n; i++) {
			p = p + input_scanner.nextInt();
		}
		
	//	close input scanner
		input_scanner.close();
	
	//	return result
		System.out.print( ( x * ( n + 1 ) ) - p );
	}

}
