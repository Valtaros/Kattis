//This is a solution for the problem "Module" from open.kattis.com
//link to problem: https://open.kattis.com/problems/modulo
package solved;
import	java.util.*;

public class Modulo
{

	public static void main(String[] args)
	{
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
	
		TreeSet<Integer> uniqueNumbers = new TreeSet<Integer>();
		
		for
		(
			int i = 0;
			i < 10;
			i++
		)
		{
			uniqueNumbers.add(inputScanner.nextInt()%42);
		}
		
		//close Scanner
		inputScanner.close();
		
		System.out.println(uniqueNumbers.size());
	}

}
