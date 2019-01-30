import	java.util.Scanner;

public class Oddities {

	public static void main(String[] args) {
		
		//	initialize input Scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get number of test cases
		int 	cases	=	input.nextInt();
		
		//	work trough test cases
		for(int i = 0 ; i < cases ; i++) {
			
			//	get input
			int nextcase	=	input.nextInt();
			
			//	choose output
			if(nextcase%2 == 0)	//	input is even
			{	
				
				//	print output
				System.out.println(nextcase+" is even");
			}
			
			else				//	input is odd
			{
				
				//	print output
				System.out.println(nextcase+" is odd");
			}
		}
		
		//	end program
		input.close();
		return;
	}

}
