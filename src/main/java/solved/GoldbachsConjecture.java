package main.java.solved;
import	java.util.Scanner;
import	java.util.ArrayList;
import	java.util.Iterator;
import	java.util.TreeSet;

public class GoldbachsConjecture
{
	
	public	static	void	main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get number of test cases
		byte	n		=	input.nextByte();
		
		//	initialize list of primes
		TreeSet<Integer>	primes			=	new TreeSet<Integer>();
		for(int i = 3 ; i < 32000 ; i++)
		{
			boolean insert	=	true;
			for(int j = 2 ; j < i && insert ; j++)
			{
				if(i%j == 0)
				{
					insert	=	false;
				}
					
			}
			if(insert)
			{
				primes.add(i);
			}
		}
		
		//	work through cases
		for(byte i = 0 ; i < n ; i++)
		{
			//	get input
			int	x			=	input.nextInt();
			
			//	check for special case (x=4)
			if(x == 4)
			{
				System.out.println("4 has 1 representation(s)\n2+2\n");
			}
			else
			{
				/*
				//	expand list of primes
				for(int j = primes_max ; j < x ; j = j + 2 )
				{
					Iterator<Integer> iter	=	primes.iterator();
					
					boolean	insert	=	true;
					
					while(iter.hasNext() && insert)
					{
						int	next	=	iter.next();
						insert =	( ( j % next ) != 0 );
					}
					
					if(insert)
					{
						primes.add(j);
					}
				}
				*/
				
				//	initialize list of representations
				ArrayList<Integer>	representations	=	new	ArrayList<Integer>();
				
				//	check for representations
				Iterator<Integer>	iter	=	primes.iterator();
				boolean				cont	=	true;
				
				while(iter.hasNext() && cont)
				{
					int	next	=	iter.next();
					if(next * 2 > x)
					{
						cont = false;
					}
					else
					{
						if( primes.contains( x - next ) )
						{
							representations.add(next);
						}
					}
				}
				
				//	print results
				System.out.println(x + " has " + representations.size() + " representation(s)");
				for(int j = 0 ; j < representations.size() ; j++)
				{
					System.out.println(representations.get(j) + "+" + ( x - representations.get(j) ) );
				}
				System.out.println();
			}
		}
		
		//	end program
		input.close();
		return;
	}

}
