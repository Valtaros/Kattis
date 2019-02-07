import	java.util.Scanner;

public class UnlockPattern
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner		input		=	new	Scanner(System.in);
		
		//	initialize variables for positions of buttons
		byte[][]	positions	=	new	byte[9][2];
		
		//	get input and safe positions
		for(byte x = 0 ; x < 3 ; x++)
		{
			for(byte y = 0 ; y < 3 ; y++)
			{
				byte	next		=	(byte)(input.nextByte() - 1);
				positions[next][0]	=	x;
				positions[next][1]	=	y;
			}
		}
		
		//	calculate distance
		double	distance		=	0;
		for(int i = 0 ; i < 8 ; i++)
		{
			distance	=	distance	+	( Math.sqrt( ( (positions[i][0] - positions[i+1][0]) * (positions[i][0] - positions[i+1][0]) ) + ( (positions[i][1] - positions[i+1][1]) * (positions[i][1] - positions[i+1][1]) ) ) );
		}
		
		//	output distance
		System.out.println(distance);
		
		//	end program
		input.close();
		return;
	}

}
