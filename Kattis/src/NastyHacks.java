import	java.util.Scanner;

public class NastyHacks
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get number of cases
		int 	n		=	input.nextInt();
		
		//	work trough cases
		for(int i = 0; i < n; i++)
		{
			int gain	=	-input.nextInt()	+input.nextInt()	-input.nextInt();
			if(gain > 0)
			{
				System.out.println("advertise");
			}
			if(gain == 0)
			{
				System.out.println("does not matter");
			}
			if(gain < 0)
			{
				System.out.println("do not advertise");
			}
		}
		
		//	end program
		input.close();
		return;
	}

}


