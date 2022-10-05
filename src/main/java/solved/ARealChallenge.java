package main.java.solved;
import	java.util.Scanner;

public class ARealChallenge
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input		=	new Scanner(System.in);
		
		//	get area of pasture
		long	volume		=	input.nextLong();
		
		//	calculate perimeter
		double	perimeter	=	Math.sqrt(volume)*4;
		
		//	output result
		System.out.println(perimeter);
		
		//	end program
		input.close();
		return;
	}

}

