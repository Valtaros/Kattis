import	java.util.Scanner;

public class LeftBeehind
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	initialize first case
		int		x		=	input.nextInt();
		int		y		=	input.nextInt();
		
		//	work through cases
		while(x != 0 || y != 0)
		{
			//	check for sum = 13
			if(x + y == 13)
			{
				System.out.println("Never speak again.");
			}
			else {
				//	compare numbers of jars
				if(x > y)
				{
					System.out.println("To the convention.");
				}
				else if(x < y)
				{
					System.out.println("Left beehind.");
				}
				else
				{
					System.out.println("Undecided.");
				}
			}
			
			//	get next case(0,0 => end)
			x	=	input.nextInt();
			y	=	input.nextInt();
		}
		
		//	end program
		input.close();
		return;
	}

}
