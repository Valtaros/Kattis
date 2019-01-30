import	java.util.Scanner;

public class TakeTwoStones {

	public static void main(String[] args) {
		
		//	initialize input Scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get input
		int 	a		=	input.nextInt();
		
		//	decide output
		if(a%2 == 0) {
			
			//	print output
			System.out.print("Bob");
		}else {
			
			//	print output
			System.out.print("Alice");
			
		}
		
		//	end program
		input.close();
		return;
	}

}
