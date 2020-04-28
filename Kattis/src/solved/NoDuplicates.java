//This is a solution for the problem "No Duplicates" from open.kattis.com
//link to problem: https://open.kattis.com/problems/nodup
package solved;

import java.util.Scanner;
import java.util.TreeSet;

public class NoDuplicates {

	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		//get input
		String inputSentence = inputScanner.nextLine();
		//close Scanner
		inputScanner.close();
		//check input
		TreeSet<String> set = new TreeSet<String>();
		String[] words = inputSentence.split(" ");
		for(int i = 0; i < words.length; i++) {
			if(set.contains(words[i])) {
				System.out.print("no");
				return;
			}else {
				set.add(words[i]);
			}
		}
		System.out.print("yes");
	}

}
