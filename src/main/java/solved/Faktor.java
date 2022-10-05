package main.java.solved;
import	java.util.Scanner;

public class Faktor {

	public static void main(String[] args) {
			//	initialize input Scanner
			Scanner	input		=	new Scanner(System.in);
			
			//	get input for calculation of result and print result
			System.out.print(	(	(	input.nextInt() * (	input.nextInt() - 1	)	) + 1	)	);
			
			//	end program
			input.close();
			return;
	}

}
