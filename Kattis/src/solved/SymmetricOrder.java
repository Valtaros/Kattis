package solved;
import	java.util.Scanner;
import	java.util.ArrayList;

public class SymmetricOrder
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner	input	=	new Scanner(System.in);
		
		//	get initial input
		byte	num_of_strings	=	input.nextByte();
		
		//	initialize set number
		int		num_of_set		=	1;
		
		//	go trough sets
		while(num_of_strings != 0)
		{
			//	initialize lists of names
			ArrayList<String>	names_1	=	new ArrayList<String>();
			ArrayList<String>	names_2	=	new ArrayList<String>();
			
			//	get names and put into two lists alternately
			for(int i = 0 ; i < num_of_strings ; i++)
			{
				if(i%2 != 1)
				{
					names_1.add(input.next());
				}
				else
				{
					names_2.add(input.next());
				}
			}
			
			//	output setnumber (and update for next run)
			System.out.println("SET " + num_of_set++);
			
			//	output first list of names
			for(int i = 0 ; i < names_1.size() ; i++)
			{
				System.out.println(names_1.get(i));
			}
			
			//	output second list of names (reverse order)
			for(int i = names_2.size() - 1; i >= 0 ; i--)
			{
				System.out.println(names_2.get(i));
			}
			
			//	get next number of strings (ends if 0)
			num_of_strings 	=	input.nextByte();
		}
		
		//	end program
		input.close();
		return;
	}

}