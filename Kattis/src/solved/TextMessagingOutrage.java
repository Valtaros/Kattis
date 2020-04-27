//This is a solution for the problem "Text Message Outrage" from open.kattis.com
//link to problem: https://open.kattis.com/problems/textmessaging
package solved;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.function.BiFunction;

public class TextMessagingOutrage {

	public static void main(String[] args) {
		Scanner	inputScanner = new Scanner(System.in);
		int numberOfCases = inputScanner.nextInt();
		for(int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
			inputScanner.nextInt();
			long keysAvailable = inputScanner.nextLong();
			long lettersInAlphabet = inputScanner.nextLong();
			HashMap<Long, Long> letterFrequencyOccurences = new HashMap<Long, Long>();
			Increment increment = new Increment();
			for(long letter = 0; letter < lettersInAlphabet; letter++) {
				Long letterFrequency = inputScanner.nextLong();
				letterFrequencyOccurences.merge(letterFrequency, (long)1, increment);
			}
			TreeSet<Long> letterFrequencies = new TreeSet<Long>();
			letterFrequencies.addAll(letterFrequencyOccurences.keySet());
			Iterator<Long> frequencyIterator = letterFrequencies.iterator();
			long totalKeyPresses = 0;
			long pressesPerLetter = lettersInAlphabet / keysAvailable + 1;
			long remainingKeys = lettersInAlphabet % keysAvailable;
			while(frequencyIterator.hasNext()) {
				long letterFrequency = (long) frequencyIterator.next();
				long frequencyOccurence = (long) letterFrequencyOccurences.get(letterFrequency);
				if(frequencyOccurence <= remainingKeys) {
					totalKeyPresses += letterFrequency*frequencyOccurence*pressesPerLetter;
					remainingKeys -= frequencyOccurence;
					if(remainingKeys == 0) {
						pressesPerLetter--;
						remainingKeys = keysAvailable;
					}
				}else{
					while(frequencyOccurence > remainingKeys) {
						totalKeyPresses += letterFrequency*remainingKeys*pressesPerLetter;
						frequencyOccurence -= remainingKeys;
						remainingKeys = keysAvailable;
						pressesPerLetter--;
					}
					totalKeyPresses += letterFrequency*frequencyOccurence*pressesPerLetter;
					remainingKeys -= frequencyOccurence;
					
				}
			}
			System.out.println("Case #" + caseNumber + ": " + totalKeyPresses);
		}
		inputScanner.close();
	}
}

class Increment implements BiFunction<Long, Long, Long>{
	public Long apply(Long oldvalue, Long newvalue) {
		return oldvalue + 1;
	}
}