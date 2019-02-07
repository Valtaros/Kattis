import	java.util.Scanner;

public class ColdPuterScience
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get number of temperatures
		byte	n		=	input.nextByte();
		
		//	initialize counter for result
		byte	result	=	0;
		
		//	count temperatures below 0
		for(byte i = 0 ; i < n ; i++)
		{
			if(input.nextInt() < 0)
			{
				result++;
			}
		}
		
		//	output result
		System.out.print(result);
		
		//	end program
		input.close();
		return;
	}

}

