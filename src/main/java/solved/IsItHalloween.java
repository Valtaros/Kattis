package main.java.solved;
import	java.util.Scanner;

public class IsItHalloween
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get input
		String	month	=	input.next();
		int		day		=	input.nextInt();
		
		//	check and output
		if((month.equals("OCT") && day == 31) || (month.equals("DEC") && day == 25))
		{
			System.out.println("yup");
		}
		else
		{
			System.out.println("nope");
		}
		
		//	end program
		input.close();
		return;
	}

}

