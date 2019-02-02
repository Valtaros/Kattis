import	java.util.Scanner;


public class Planina {

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
			
		//	get input
		int		n		=	input.nextInt();
		
		//	generate output
		int		points	=	1;
		for(int i = 0; i < n ; i++)
		{
			points	=	points*2;
		}
		points++;
		System.out.println(points*points);
		
		
		//	end program
		input.close();
		return;
	}

}
