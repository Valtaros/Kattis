package solved;
import	java.util.Scanner;

public class Apaxiaaaaaaaaaaaans
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get input
		String	in		=	input.next();
		
		//	initialize output
		String	out		=	""+in.charAt(0);
		
		//	generate output
		char	last	=	in.charAt(0);
		for(int i = 1; i < in.length(); i++)
		{
			if(in.charAt(i) != last)
			{
				out		=	out	+	in.charAt(i);
				last	=	in.charAt(i);
			}
		}
		
		//	output result
		System.out.print(out);
		
		//	end program
		input.close();
		return;
	}

}
