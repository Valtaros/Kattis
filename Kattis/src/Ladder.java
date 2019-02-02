import	java.util.Scanner;

public class Ladder
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get input
		int 	h		=	input.nextInt();
		double	v		=	input.nextDouble() / 360 * 2 * Math.PI;
		
		//	calculate length
		int		length	=	(int) (h/Math.sin(v)) + 1 ;
		
		//	output
		System.out.println(length);
		
		//	end program
		input.close();
		return;
	}

}

