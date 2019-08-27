package solved;
import	java.util.Scanner;

public class Bijele
{

	public static void main(String[] args)
	{
		//	initialize input Scanner
		Scanner	input		=	new Scanner(System.in);
		
		//	generate output
		System.out.print(	( 1-input.nextInt() ));
		System.out.print(" ");
		System.out.print(	( 1-input.nextInt() ));
		System.out.print(" ");
		System.out.print(	( 2-input.nextInt() ));
		System.out.print(" ");
		System.out.print(	( 2-input.nextInt() ));
		System.out.print(" ");
		System.out.print(	( 2-input.nextInt() ));
		System.out.print(" ");
		System.out.print(	( 8-input.nextInt() ));
		
		//	end program
		input.close();
		return;
	}

}
