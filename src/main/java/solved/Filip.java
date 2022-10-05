package main.java.solved;
import	java.util.Scanner;

public class Filip
{

	public static void main(String[] args)
	{
		//	initialize input Scanner
		Scanner	input		=	new Scanner(System.in);
		
		//	get input as String
		String	num_in_1	=	input.next();
		String	num_in_2	=	input.next();
		
		//	flip input 
		String	num_out_1	=	"";
		for(int i = 2; i >= 0 ; i--)
		{
			num_out_1		=	num_out_1+num_in_1.charAt(i);
		}
		String	num_out_2	=	"";
		for(int i = 2; i >= 0 ; i--)
		{
			num_out_2		=	num_out_2+num_in_2.charAt(i);
		}
		
		//	change to integer
		int 	out1		=	Integer.parseInt(num_out_1);
		int		out2		=	Integer.parseInt(num_out_2);
		
		//	output
		if(out1 > out2)
		{
			System.out.print(out1);
		}
		else
		{
			System.out.print(out2);
		}
		
		//	end program
		input.close();
		return;
	}

}
