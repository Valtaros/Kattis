package solved;
import	java.util.Scanner;

public class Heliocentric
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input		=	new Scanner(System.in);
		
		//	initialize case counter
		byte	testcase	=	1;

		//	check for input and work through case
		while(input.hasNext())
		{
			//	get earth and mars start day
			int	earth	=	input.nextInt();
			int	mars	=	input.nextInt();
			
			//	initialize day counter
			int	count	=	0;
			
			//	advance mars to 0
			if(mars != 0)
			{
				count	= 687 - mars;
				mars	=	0;
				earth	= (earth + count ) % 365;
			}
			
			//	make turns with mars (0 to 0) until earth is at 0 too
			while(earth != 0)
			{
				count	=	count + 687;
				earth	=	( earth + 687 ) % 365;
			}
			
			//	output number of days taken
			System.out.println("Case " + (testcase++) + ": " + count);
		}
		
		//	end program
		input.close();
		return;
	}

}

