package solved;
import	java.util.Scanner;
import	java.util.ArrayList;

public class IveBeenEverywhereMan
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input		=	new Scanner(System.in);
		
		//	get number of testcases
		byte	testcases	=	input.nextByte();
		
		//	work trough testcases
		for(byte i = 0 ; i < testcases ; i++)
		{
			//	get number of cities
			byte	num_cities	=	input.nextByte();
			
			//	get unique city names
			ArrayList<String>	list_of_cities	=	new ArrayList<String>();
			for(byte j = 0 ; j < num_cities ; j++)
			{
				String next_city	=	input.next();
				if(!list_of_cities.contains(next_city))
				{
					list_of_cities.add(next_city);
				}
			}
			
			//	output number of unique cities
			System.out.println(list_of_cities.size());
		}

		//	end program
		input.close();
		return;
	}

}

