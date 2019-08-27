package solved;
import	java.util.Scanner;

public class GrassSeedInc
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get cost of seed
		double	c		=	input.nextDouble();
		
		//	get number of lawns
		int		l		=	input.nextInt();
		
		//	initialize output
		double	output	=	0;
		
		//	sum up lawns
		for(int i = 0; i < l; i++)
		{
			output	=	output + (c * input.nextDouble() * input.nextDouble());
		}
		
		//	print result
		System.out.println(output);
		
		//	end program
		input.close();
		return;
	}

}

