import	java.util.Scanner;

public class StuckInATimeLoop {

	public static void main(String[] args) {
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get input
		int 	n		=	input.nextInt();
		
		//	generate output
		for(int i = 0; i < n ; i++)
		{
			System.out.println((i+1)+" Abracadabra");
		}
		
		//	end program
		input.close();
		return;
	}

}

