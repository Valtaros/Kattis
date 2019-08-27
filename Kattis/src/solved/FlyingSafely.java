package solved;
import	java.util.Scanner;

public class FlyingSafely
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get number of cases
		int		cases	=	input.nextInt();
		
		//	work through cases
		for(int i = 0 ; i < cases ; i++)
		{
			//	get number of cities
			int	n	=	input.nextInt();
			
			//	get number of pilots
			int	m	=	input.nextInt();
			
			//	skip flight data (not needed)
			for(int j = 0 ; j < m ; j++)
			{
				input.next();
				input.next();
			}
			
			//	output result
			System.out.println((n-1));
		}
		
		//	end program
		input.close();
		return;
	}

}
