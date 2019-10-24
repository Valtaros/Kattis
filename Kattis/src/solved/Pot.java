package solved;
import	java.util.Scanner;

public class Pot
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get number of integers
		byte	n		=	input.nextByte();
		
		//	initialize sum
		int sum			=	0;
		
		//	add powers
		for(byte i = 0 ; i < n ; i++)
		{
			//	get input
			int	next	=	input.nextInt();
		
			//	get power
			int	power	=	next % 10;
			
			//	get number 
			int number	=	next / 10;
			
			//	calculate next summand
			int	summand	=	1;
			for(int j = 0 ; j < power ; j++)
			{
				summand = summand * number;
			}
			
			//	add next summand
			sum	=	sum + summand;
		}
		
		//	output sum
		System.out.println(sum);
				
		//	end program
		input.close();
		return;
	}

}
