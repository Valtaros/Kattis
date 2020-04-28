//This is a solution for the problem "Illiteracy" from open.kattis.com
//link to problem: https://open.kattis.com/problems/illiteracy
package solved;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;


public class Illiteracy {

	public static void main(String[] args) {
		//get input
		Scanner	inputScanner = new Scanner(System.in);
		Combination initialCombination = new Combination(inputScanner.next());
		Combination goalCombination = new Combination(inputScanner.next());
		inputScanner.close();
		
		//check if initial = goal
		if(initialCombination.equals(goalCombination)) {
			System.out.print(0);
			return;
		}
		
		//setup search
		boolean searchNext = true;
		int stepCount = 0;
		TreeSet<Combination> nextCombinationsChecked = new TreeSet<Combination>();
		TreeSet<Combination> nextCombinationsToCheck = new TreeSet<Combination>();
		TreeSet<Combination> nextCombinationsNew = new TreeSet<Combination>();
		nextCombinationsToCheck.add(initialCombination);
		//do search
		while(true) {
			stepCount++;
			if(searchNext) {
				for(Combination combinationToCheck: nextCombinationsToCheck) {
					//get all possible following combinations
					nextCombinationsNew.addAll(combinationToCheck.getPossibleNextCombinations());
					//mark combination as checked
					nextCombinationsChecked.add(combinationToCheck);
				}
				nextCombinationsToCheck.clear();
				//check new combinations for compatibility
				for(Combination combinationNew: nextCombinationsNew) {
					//check if new combination was already checked, if so, skip
					if(!nextCombinationsChecked.contains(combinationNew)) {
						//check if new combination matches a before combination
						if(goalCombination.equals(combinationNew)) {
							System.out.print(stepCount);
							return;
						}
						//move combination to toCheck-set
						nextCombinationsToCheck.add(combinationNew);
					}
				}
				//clear new-set
				nextCombinationsNew.clear();
			}
		}
	}
}

class Combination implements Comparable<Combination>{
	private byte[] symbols;
	
	public Combination(String string) {
		this.symbols = new byte[8];
		for(int index = 0; index < 8; index++) {
			switch(string.charAt(index)) {
			case 'A':
				this.symbols[index] = 0;
				break;
			case 'B':
				this.symbols[index] = 1;
				break;
			case 'C':
				this.symbols[index] = 2;
				break;
			case 'D':
				this.symbols[index] = 3;
				break;
			case 'E':
				this.symbols[index] = 4;
				break;
			case 'F':
				this.symbols[index] = 5;
				break;
			}
		}
	}
	
	public Combination(Combination that) {
		this.symbols = new byte[8];
		for(int index = 0; index < 8; index++) {
			this.symbols[index] = that.symbols[index];
		}
	}
	
	@Override
	public int compareTo(Combination that) {
		for(int i = 0; i < 8; i++) {
			if(this.symbols[i] < that.symbols[i]) {
				return -1;
			}
			if(this.symbols[i] > that.symbols[i]) {
				return 1;
			}
		}
		return 0;
	}
	
	public boolean equals(Combination that) {
		for(int i = 0; i < 8; i++) {
			if(this.symbols[i] != that.symbols[i]) {
				return false;
			}
		}
		return true;
	}

	public TreeSet<Combination> getPossibleNextCombinations(){
		TreeSet<Combination> result = new TreeSet<Combination>();
		for(int index = 0; index < 8; index++) {
			switch(this.symbols[index]) {
			case 0: result.add(doA(index)); break;
			case 1: result.add(doB(index)); break;
			case 2: result.add(doC(index)); break;
			case 3: result.add(doD(index)); break;
			case 4: result.add(doE(index)); break;
			case 5: result.add(doF(index)); break;
			}
		}
		return result;
	}

	private void rotate(int index) {
		if(this.symbols[index] != 5) {
			this.symbols[index] += 1;
		}else {
			this.symbols[index] = 0;
		}
	}

	private Combination doA(int index) {
		Combination result = new Combination(this);
		switch(index) {
		case 0:
			result.rotate(1);
			break;
		case 7:
			result.rotate(6);
			break;
		default:
			result.rotate(index - 1);
			result.rotate(index + 1);
			break;
		}
		return result;
	}
	
	private Combination doB(int index) {
		Combination result = new Combination(this);
		switch(index) {
		case 0:
		case 7: break;
		default:
			result.symbols[index + 1] = result.symbols[index - 1];
			break;
		}
		return result;
	}
	
	private Combination doC(int index) {
		Combination result = new Combination(this);
		result.rotate(7 - index);
		return result;
	}
	
	private Combination doD(int index) {
		Combination result = new Combination(this);
		switch(index) {
		case 3: result.rotate(2);
		case 2: result.rotate(1);
		case 1: result.rotate(0);
		case 0: break;
		case 4: result.rotate(5);
		case 5: result.rotate(6);
		case 6: result.rotate(7);
		case 7: break;
		}
		return result;
	}
	
	private Combination doE(int index) {
		Combination result = new Combination(this);
		int offset;
		if(index < 4) {
			offset = index;
		}else {
			offset = 7 - index;
		}
		if(offset != 0) {
			result.rotate(index - offset);
			result.rotate(index + offset);
		}
		return result;
	}
	
	private Combination doF(int index) {
		Combination result = new Combination(this);
		if(index % 2 != 0) {
			result.rotate(((index + 1) / 2) - 1);
		}else {
			result.rotate((index + 8) / 2);
		}
		return result;
	}
}
