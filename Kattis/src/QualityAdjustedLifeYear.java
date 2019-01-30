import	java.util.Scanner;

public class QualityAdjustedLifeYear {

	public static void main(String[] args) {
		
		//	initialize input scanner
		Scanner input	=	new Scanner(System.in);
		
		//	get number of inputs
		int	a	=	input.nextInt();
		
		//	initialize output
		double	result	=	0;
		
		//	get a inputs and calculate sum of products
		for(int i = 0; i < a; i++) {
			double	quality	=	input.nextDouble();
			double	time	=	input.nextDouble();
			result	=	result + (quality*time);
		}
		
		//	print result
		System.out.print(result);
		
		//end program
		input.close();
		return;
	}

}
