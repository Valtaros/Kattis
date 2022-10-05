package main.java.solved;
import	java.util.Scanner;

public class Bishops
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	check for input
		while(input.hasNext())
		{
			//	get size
			int	n	=	input.nextInt();
			
			//	check for special case (n=1)
			if(n == 1)
			{
				//	output 1
				System.out.println(1);
			}
			else
			{
				//	output result
				System.out.println( ( (n - 1) * 2 ) );
			}
		}

		
		//	end program
		input.close();
		return;
	}

}
