package solved;
import	java.util.Scanner;

public class R2 {

	public static void main(String[] args) {
		
		//	initialize input Scanner
		Scanner input	=	new Scanner(System.in);
		
		//	get input
		int 	r1		=	input.nextInt();
		int		s		=	input.nextInt();
		
		//	return result
		System.out.print(((2*s)-r1));
		
		//	end program
		input.close();
		return;
	}

}
