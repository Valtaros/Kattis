package solved;
import java.util.Scanner;

public class Spavanac {

	public static void main(String[] args) {
		
	//	initialize input scanner
		Scanner input_scanner = new Scanner(System.in);
		
	//	read input 
		
		//	hour
		int h	= input_scanner.nextInt();
		
		//minute
		int m	= input_scanner.nextInt();
	
	//	close input scanner
		input_scanner.close();
		
	//	adjust time
		if(m > 44) {
			m = m - 45;
		}
		else /*(m <= 44)*/ {
			m = m + 15;
			if(--h < 0) {
				h = 23;
			}
		}
	
	//	output result
		System.out.print(h+" "+m);
	}
	

}
