package solved;
import	java.util.Scanner;

public class LastFactorialDigit {

	public static void main(String[] args) {
		
		//	initialize input Scanner
		Scanner input	=	new Scanner(System.in);
		
		//	get number of cases
		int 	cases	=	input.nextInt();
				
		//	work through cases
		for(int i = 0 ; i < cases ; i++) {
			switch(input.nextInt())
			{
			case	1:	System.out.println(1);
						break;
			case	2:	System.out.println(2);
						break;
			case	3:	System.out.println(6);
						break;
			case	4:	System.out.println(4);
						break;
			default:	System.out.println(0);
						break;
			}
		}
		
		//	end program
		input.close();
		return;
	}

}
