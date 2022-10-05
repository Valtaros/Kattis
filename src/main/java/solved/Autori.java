package main.java.solved;
import	java.util.Scanner;

public class Autori
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get input
		String	in		=	input.next();
		
		//	initialize output
		String	out		=	"";
		
		//	go through input
		for(int i = 0 ; i < in.length() ; i++ )
		{
			if(in.charAt(i) >= 'A' && in.charAt(i) <= 'Z')
			{
				out	=	out	+	in.charAt(i);
			}
		}
		
		//	output result
		System.out.println(out);
		
		//	end program
		input.close();
		return;
	}

}
