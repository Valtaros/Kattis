package main.java.solved;
import	java.util.Scanner;

public class CryptographersConundrum
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get input
		String	in		=	input.next();
		
		//	initialize output
		int 	count	=	in.length();
		
		//	check for "PER"
		for(int i = 0; i < in.length(); i++)
		{
			if(i%3 == 0 && in.charAt(i) == 'P')
			{
				count--;
			}
			if(i%3 == 1 && in.charAt(i) == 'E')
			{
				count--;
			}
			if(i%3 == 2 && in.charAt(i) == 'R')
			{
				count--;
			}
			
		}
		
		//	print result
		System.out.println(count);
		
		//	end program
		input.close();
		return;
	}

}
