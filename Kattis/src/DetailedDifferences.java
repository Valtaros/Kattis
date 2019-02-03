import	java.util.Scanner;

public class DetailedDifferences
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get number of cases
		int		n		=	input.nextInt();
		
		//	check cases
		for(int i = 0; i < n; i++)
		{
			//	get input
			String	in_1	=	input.next();
			String	in_2	=	input.next();
			
			//	initialize output
			String	out		=	in_1+"\n"+in_2+"\n";
			
			//	compare Strings
			for(int j = 0; j < in_1.length(); j++)
			{
				if(in_1.charAt(j) != in_2.charAt(j))
				{
					out =	out	+	"*"; 
				}
				else
				{
					out	=	out	+	".";
				}
			}
			
			//	finish output
			out	=	out	+	"\n\n";
			
			//	print output
			System.out.print(out);
			
		}
		
		//	end program
		input.close();
		return;
	}

}
