package solved;
import	java.util.Scanner;

public class Sibice {

	public static void main(String[] args) {
		
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get number of matches
		int		matches	=	input.nextInt();
		
		//	get dimensions of box
		int		w		=	input.nextInt();
		int		h		=	input.nextInt();
		int		size	=	(int)	Math.sqrt( (w * w ) + ( h * h ) );
		
		//	check matches
		for(int i = 0; i < matches; i++)
		{
			if(input.nextInt() <= size)
			{
				System.out.println("DA");
			}
			else
			{
				System.out.println("NE");
			}
		}
		
		//	end program
		input.close();
		return;
	}

}
