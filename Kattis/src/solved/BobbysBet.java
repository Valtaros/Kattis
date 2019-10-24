package solved;
import	java.util.Scanner;


public class BobbysBet
{
	public	static	double		binomialcoefficient(int n , int k)
	{
		//	initialize result
		double	binomialcoefficient	=	1;
		
		//	multiply by n!
		for(int i = 1; i <= n ; i++)
		{
			binomialcoefficient	=	binomialcoefficient * i;
		}
		
		//	divide by (n-k)!
		for(int i =	1 ; i <= (n-k) ; i++)
		{
			binomialcoefficient	=	binomialcoefficient / i;
		}
		
		//	divide by k!
		for(int i = 1 ; i <= k ; i++)
		{
			binomialcoefficient	=	binomialcoefficient / i;
		}
		
		//	return result
		return binomialcoefficient;
	}

	public	static	double		numerator(int r, int s, int x, int y)
	{
		//	initialize result
		double numerator	=	1;
		
		//	multiply chances to win
		for(int i = 0 ; i < x ; i++)
		{
			numerator	=	numerator * (s-r+1);
		}
		
		//	multiply chances to lose
		for(int i = 0 ; i < (y-x) ; i++ )
		{
			numerator	=	numerator * (r-1);
		}
		
		//	return result
		return	numerator;
	}
	
	public	static	double		denominator(int s, int y)
	{
		//	initialize result
		double		denominator	=	1;
		
		//	multiply by s , y times 
		for(int i = 0 ; i < y ; i++)
		{
			denominator	=	denominator * s;
		}
		
		//	return result
		return	denominator;
	}
	
	public	static	void	main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get number of test cases
		int		cases	=	input.nextInt();
		
		//	work through cases
		for(int i = 0 ; i < cases ; i++)
		{
			//	get input
			int		r	=	input.nextInt();
			int		s	=	input.nextInt();
			int		x	=	input.nextInt();
			int		y	=	input.nextInt();
			double	w	=	input.nextDouble();
			
			//	sum up expected returns for each number of wins >= x
			double	expected_return	=	0;
			for(int j = x ; j <= y ; j++)
			{
				expected_return	=	expected_return + ( w * binomialcoefficient( y , j ) * numerator( r , s , j , y ) / denominator( s , y ) );
			}
			
			//	output
			if(expected_return > 1)
			{
				System.out.println("yes");
			}
			else
			{
				System.out.println("no");
			}
			
		}
		
		//	end program
		input.close();
		return;
	}

}
