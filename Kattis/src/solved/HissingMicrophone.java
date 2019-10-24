package solved;
import	java.util.Scanner;

public class HissingMicrophone
{
	public static void main(String[] args)
	{
		//	initialize input Scanner
		Scanner input	=	new Scanner(System.in);
		
		//	get input
		String	s		=	input.next();
		
		//	initialize checking variable
		boolean	check	=	false;
		
		//	check input
		for(int i = 0; i < (s.length()-1); i++)
		{
			//	check if char at index i is "s"
			if(s.charAt(i) == 's')
			{	
				//	check if following char is "s"
				if(s.charAt(i+1) == 's')
				{
					//	set checking variable
					check = true;
				}
			}
		}
		
		//	output
		if(!check)
		{
			System.out.print("no ");
		}
		System.out.print("hiss");
		
		//	end program
		input.close();
		return;
	}
}
