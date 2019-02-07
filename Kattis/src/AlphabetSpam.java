import	java.util.Scanner;

public class AlphabetSpam
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input		=	new Scanner(System.in);
		
		//	get input
		String	in			=	input.next();
		
		//	initialize counters for result
		int		whitespace	=	0;
		int		lowercase	=	0;
		int		uppercase	=	0;
		int		symbols		=	0;
		
		//	check input and count categories
		for(int i = 0; i < in.length(); i++)
		{
			char	next	=	in.charAt(i);
			if(next == '_')
			{
				whitespace++;
			}
			else if(next <= 'z' && next >= 'a')
			{
				lowercase++;
			}
			else if(next <= 'Z' && next >= 'A')
			{
				uppercase++;
			}
			else {
				symbols++;
			}			
		}
		
		//	calculate ratios
		double	whitespace_ratio = (double)whitespace/(double)in.length();
		double	lowercase_ratio = (double)lowercase/(double)in.length();
		double	uppercase_ratio = (double)uppercase/(double)in.length();
		double	symbols_ratio = (double)symbols/(double)in.length();
		
		//	output result
		System.out.print( whitespace_ratio + "\n" + lowercase_ratio + "\n" + uppercase_ratio + "\n" + symbols_ratio);
		
		//	end program
		input.close();
		return;
	}

}
