//This is a solution for the problem "DA-Sort" from open.kattis.com
//link to problem: https://open.kattis.com/problems/dasort
package solved;
import	java.util.Scanner;

public class DA_Sort {
	
	public static void main(String[] args)
	{
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		
		//get number of cases
		int cases = inputScanner.nextInt();
		
		//create array for solutions
		int[] operations = new int[cases];
		for(int i = 1; i <= cases; i++) {
			//read case parameter
			int caseNumber = inputScanner.nextInt() - 1;
			int size = inputScanner.nextInt();
			
			//read case
			int[] caseArray = new int[size];
			for(int j = 0; j < size; j++) {
				caseArray[j] = inputScanner.nextInt();
			}
			
			//initialize helper variables
			int min = caseArray[size-1];
			int pos = size-2;
			int count = 0;
			int minMoved = 1000000001;
			//System.out.println("Case " + caseNumber + ":");
			//check for numbers bigger than following numbers
			//System.out.println("First round:");
			while(pos != -1) {
				if(caseArray[pos] <= min) {
					//System.out.println("min " + min + " is bigger/equal than " + caseArray[pos] + "(caseArray[" + pos + "])");
					min = caseArray[pos];
					//System.out.println("Set caseArray[" + pos + "] to " + min);
					pos--;
					//System.out.println("Set pos to " + pos);
				}else {
					//System.out.println("min " + min + " is smaller than " + caseArray[pos] + "(caseArray[" + pos + "])");
					if(minMoved > caseArray[pos]) {
						//System.out.println("minMoved " + minMoved + " is bigger than " + caseArray[pos] + "(caseArray[" + pos + "])");
						minMoved = caseArray[pos];
						//System.out.println("Set minMoved to " + caseArray[pos] + "(caseArray[" + pos + "])");
					}
					caseArray[pos] = -1;
					//System.out.println("Set " + "caseArray[" + pos + "] to " + 0);
					pos--;
					//System.out.println("Set pos to " + pos);
					count++;
					//System.out.println("Increment count to " + count);
				}
				
			}
			//System.out.println("Second round:");
			//check for numbers smaller than the smallest moved number
			pos = 0;
			while(pos < size) {
				if(caseArray[pos] > minMoved) {
					//System.out.println("(caseArray[" + pos + "]) is bigger/equal than minMoved " + minMoved);
					pos++;
					//System.out.println("Set pos to " + pos);
					count++;
					//System.out.println("Increment count to " + count);
				}else {
					//System.out.println("(caseArray[" + pos + "]) is smaller than minMoved " + minMoved);
					pos++;
					//System.out.println("Set pos to " + pos);
				}
			}
			/*
			//check last number separately (equality with smallest moved does not require move)
			if(caseArray[pos] > minMoved) {
				//System.out.println("Last entry " + caseArray[pos] + " is bigger than minMoved " + minMoved);
				count++;
				//System.out.println("Increment count to " + count);
			}
			*/
			/*
			//write solution to array
			operations[caseNumber] = count;
			*/
			//output solution
			System.out.println((caseNumber + 1) + " " + count);
		}
		//close Scanner
		inputScanner.close();
		/*
		//output solution
		for(int i = 0; i < cases; i++) {
			System.out.println( (i+1) + " " + operations[i]);
		}
		*/
	}
}
