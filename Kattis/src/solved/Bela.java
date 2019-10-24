package solved;
import	java.util.Scanner;

public class Bela
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get number of hands and dominant suit
		byte	n		=	input.nextByte();
		String	b		=	input.next();
		
		//	initialize result (sum of card values)
		int		result	=	0;
		
		//	check cards and add values
		for(int i = 0 ; i < n*4 ; i++)
		{
			String	nextcard	=	input.next();
			switch(nextcard.charAt(0)) {
			case	'A'	:	result	=	result	+	11;	break;
			case	'K'	:	result	=	result	+	4;	break;
			case	'Q'	:	result	=	result	+	3;	break;
			case	'J'	:	if(nextcard.charAt(1) == b.charAt(0)) {result	=	result	+	20;}else{result	=	result	+	2;};	break;
			case	'T'	:	result	=	result	+	10;	break;
			case	'9'	:	if(nextcard.charAt(1) == b.charAt(0)) {result	=	result	+	14;};	break;
			default		:	break;	
			}
		}
		
		//	output result
		System.out.print(result);
		
		//	end program
		input.close();
		return;
	}

}
