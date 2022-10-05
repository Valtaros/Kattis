package main.java.solved;
import	java.util.Scanner;

public class QuadrantSelection {

	public static void main(String[] args) {
		
		//	initialize input Scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get input
		int	x	=	input.nextInt();
		int	y	=	input.nextInt();
		
		//	check x value
		if(x > 0)	//	x > 0 => Quadrant 1/4
		{
			
			//check y value
			if(y > 0)	//	y > 0 => Quadrant 1
			{
				System.out.print(1);
			}
			
			else		//	y < 0 => Quadrant 4
			{
				System.out.print(4);
			}
		}
		
		else		//	x < 0 => Quadrant 2/3
		{
			
			//check y value
			if(y > 0)	//	y > 0 => Quadrant 2
			{
				System.out.print(2);
			}
			
			else		//	y < 0 => Quadrant 3
			{
				System.out.print(3);
			}
		}
		
		//	end program
		input.close();
		return;
	}

}
