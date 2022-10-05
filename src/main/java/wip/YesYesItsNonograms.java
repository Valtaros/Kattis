//This is a solution for the problem "Yes, Yes, It's Nonograms" from open.kattis.com
//link to problem: https://open.kattis.com/problems/yesyes

/*
 * Implementation 2
 * based on implementation 1, ArrayLists were replaced by arrays where applicable, remaining ArrayLists were trimmed if possible, values for pixels were changed from byte to boolean type.
 * None of this fixed the problem of high memory consumption.
 * After finally doing some math (i feel stupid for not trying this before) it turns out, that the shear number of possible solutions (in a nearly worst case) for a single row is way to high for storing in memory
 * Another approach for generation of possible solutions is required, without the option for storage.
 */

//package java.wip;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class YesYesItsNonograms {
//
//	public static void main(String[] args) {
//		Scanner inputScanner = new Scanner(System.in);
//		int rowCount = inputScanner.nextInt();
//		int columnCount = inputScanner.nextInt();
//		ArrayList<Row> rows = new ArrayList<Row>(0);
//		ArrayList<Row> columns = new ArrayList<Row>(0);
//		for(int i = 0; i < rowCount; i++) {
//			int sequenceCount = inputScanner.nextInt();
//			ArrayList<Integer> blackPixelSequences = new ArrayList<Integer>(0);
//			for(int j = 0; j < sequenceCount; j++) {
//				blackPixelSequences.add(inputScanner.nextInt());
//			}
//			rows.add(new Row(blackPixelSequences, columnCount));
//		}
//		for(int i = 0; i < columnCount; i++) {
//			int sequenceCount = inputScanner.nextInt();
//			ArrayList<Integer> blackPixelSequences = new ArrayList<Integer>(0);
//			for(int j = 0; j < sequenceCount; j++) {
//				blackPixelSequences.add(inputScanner.nextInt());
//			}
//			columns.add(new Row(blackPixelSequences, rowCount));
//		}
//		inputScanner.close();
//
//		boolean continueChecking = true;
//		while(continueChecking) {
//			continueChecking = false;
//			for(int i = 0; i < rowCount; i++) {
//				if(rows.get(i).getCheckingRequired()) {
//					ArrayList<Integer> changedColumns = rows.get(i).check();
//					if(!changedColumns.isEmpty()) {
//						continueChecking = true;
//						for(int j = 0; j < changedColumns.size(); j++) {
//							columns.get(changedColumns.get(j)).setPixel(i, rows.get(i).getPixel(changedColumns.get(j)));
//							columns.get(changedColumns.get(j)).setCheckingRequired();
//						}
//					}
//				}
//			}
//			
//			for(int i = 0; i < columnCount; i++) {
//				if(columns.get(i).getCheckingRequired()) {
//					ArrayList<Integer> changedRows = columns.get(i).check();
//					if(!changedRows.isEmpty()) {
//						continueChecking = true;
//						for(int j = 0; j < changedRows.size(); j++) {
//							rows.get(changedRows.get(j)).setPixel(i, columns.get(i).getPixel(changedRows.get(j)));
//							rows.get(changedRows.get(j)).setCheckingRequired();
//						}
//					}
//				}
//			}
//		}
//		
//		for(int i = 0; i < rows.size(); i++) {
//			rows.get(i).printRow();
//		}
//		
//	}	
//}
//
//class SequenceGenerator {
///*
// * This class is responsible for creating possible sequences of pixels for a given row or column in the whole array.
// */
//	
////Attributes	
//	//list of separate sequences of black pixels, separated by at least one white pixel
//	private ArrayList<Integer> blackPixelSequences;
//	//total length of the sequence counting all black and white pixels
//	private int totalSequenceLength;
//	//number of "non movable" pixels. these are all black pixels and one white pixel in between
//	private int numberOfFixedPixels;
//	
////Constructor	
//	public SequenceGenerator(ArrayList<Integer> blackPixelSequences, int totalSequenceLength) {
//		//initialize list of sequences of black pixels
//		this.blackPixelSequences = new ArrayList<Integer>(0);
//		//populate list of sequences of black pixels
//		this.blackPixelSequences.addAll(blackPixelSequences);
//		//set total length of pixel sequence
//		this.totalSequenceLength = totalSequenceLength;
//		//initialize count of fixed pixels with count of necessary white pixels
//		this.numberOfFixedPixels = this.blackPixelSequences.size() - 1;
//		//add all black pixels to count
//		for(int i = 0; i < this.blackPixelSequences.size(); i++) {
//			numberOfFixedPixels += this.blackPixelSequences.get(i);
//		}
//	}
//
//	private ArrayList<ArrayList<Integer>> createPossibleWhitePixelPlacements(int unusedPixels, int remainingPositions){
//		ArrayList<ArrayList<Integer>> listOfNumberSequences = new ArrayList<ArrayList<Integer>>(0);
//		if(remainingPositions > 1) {
//			for(int i = 0; i <= unusedPixels; i++) {
//				ArrayList<ArrayList<Integer>> listOfFollowingSequences = createPossibleWhitePixelPlacements(unusedPixels - i, remainingPositions - 1);
//				listOfFollowingSequences.trimToSize();
//				for(int j = 0; j < listOfFollowingSequences.size(); j++) {
//					ArrayList<Integer> newSequence = new ArrayList<Integer>(0);
//					newSequence.add(i);
//					newSequence.addAll(listOfFollowingSequences.get(j));
//					listOfNumberSequences.add(newSequence);
//				}
//			}
//		}else {
//			ArrayList<Integer> newSequence = new ArrayList<Integer>(0);
//			newSequence.add(unusedPixels);
//			listOfNumberSequences.add(newSequence);
//		}
//		listOfNumberSequences.trimToSize();
//		return listOfNumberSequences;
//	}
//	
//	public ArrayList<PixelSequence> createListOfPixelSequences(){
//		ArrayList<ArrayList<Integer>> listOfPossibleWhitePixelPlacements = createPossibleWhitePixelPlacements(totalSequenceLength - numberOfFixedPixels, blackPixelSequences.size()+1);
//		ArrayList<PixelSequence> pixelSequences = new ArrayList<PixelSequence>(0);
//		for(int i = 0; i < listOfPossibleWhitePixelPlacements.size(); i++) {
//			ArrayList<Integer> whitePixelSequences = listOfPossibleWhitePixelPlacements.get(i);
//			boolean[] pixels = new boolean[totalSequenceLength];
//			int numberOfWhiteSequences = whitePixelSequences.size();
//			int numberOfBlackSequences = blackPixelSequences.size();
//			int arrayPointer = 0;
//			//add first white sequence to pixel sequence
//			for(int j = 0; j < whitePixelSequences.get(0); j++) {
//				pixels[arrayPointer++] = false;
//			}
//			//add all but last black and white sequences
//			for(int j = 1; j < numberOfWhiteSequences - 1; j++) {
//				for(int k = 0; k < blackPixelSequences.get(j - 1); k++) {
//					pixels[arrayPointer++] = true;
//				}
//				for(int k = 0; k < whitePixelSequences.get(j) + 1; k++) {
//					pixels[arrayPointer++] = false;
//				}
//			}
//			//add last black sequence
//			for(int j = 0; j < blackPixelSequences.get(numberOfBlackSequences - 1); j++) {
//				pixels[arrayPointer++] = true;
//			}
//			//add last white sequence
//			for(int j = 0; j < whitePixelSequences.get(numberOfWhiteSequences - 1); j++) {
//				pixels[arrayPointer++] = false;
//			}
//			pixelSequences.add(new PixelSequence(pixels));
//		}
//		pixelSequences.trimToSize();
//		return pixelSequences;
//	}
//}
//
//class PixelSequence {
//	//Sequence of Byte representing pixel states. 0 = unknown, 1 = black, 2 = white
//	private boolean[] pixels;
//	
//	public PixelSequence(boolean[]pixels) {
//		this.pixels = pixels;
//	}
//	
//	public boolean compareIndex(PixelSequence that, int index) {
//		return this.pixels[index] == that.pixels[index];
//	}
//	
//	public boolean getPixel(int index) {
//		return pixels[index];
//	}
//	
//	public void setPixel(int index, boolean value) {
//		pixels[index] = value;
//	}
//	
//	//checks if the sequence is compatible with a given sequence containing unknown pixels
//	public boolean getCompatibility(Boolean[] that) {
//		for(int i = 0; i < this.pixels.length; i++) {
//			if(that[i] != null && this.pixels[i] != that[i]) {
//				return false;
//			}
//		}
//		return true;
//	}
//}
//
//class Row{
//	private Boolean[] solution;
//	private ArrayList<PixelSequence> possibleSolutions;
//	private boolean requiresChecking;
//	private int length;
//	
//	public Row(ArrayList<Integer> blackPixelSequences, int totalSequenceLength) {
//		//create solution containing only unknown pixels
//		solution = new Boolean[totalSequenceLength];
//		//create list of possible solutions
//		SequenceGenerator generator = new SequenceGenerator(blackPixelSequences, totalSequenceLength);
//		this.possibleSolutions = generator.createListOfPixelSequences();
//		//set checking flag
//		requiresChecking = true;
//		//set length
//		length = totalSequenceLength;
//	}
//	
//	public void setCheckingRequired() {
//		requiresChecking = true;
//	}
//	
//	public boolean getCheckingRequired() {
//		return requiresChecking;
//	}
//	
//	public void setPixel(int index, boolean value) {
//		solution[index] = value;
//	}
//	
//	public Boolean getPixel(int index) {
//		return solution[index];
//	}
//	
//	public ArrayList<Integer> check(){
//		ArrayList<Integer> changedColumns = new ArrayList<Integer>(0);
//
//		for(int i = possibleSolutions.size() - 1; i >= 0; i--) {
//			if(!possibleSolutions.get(i).getCompatibility(solution)) {
//				possibleSolutions.remove(i);
//			}
//		}
//
//		if (possibleSolutions.size() > 1) {
//			for (int index = 0; index < length; index++) {
//				if (getPixel(index) == null) {
//					if(checkIndex(index)) {
//						solution[index] = possibleSolutions.get(0).getPixel(index);
//						changedColumns.add(index);
//					}
//				}
//			} 
//		}else {
//			for(int i = 0; i < length; i++) {
//				if (solution[i] == null) {
//					changedColumns.add(i);
//					solution[i] = possibleSolutions.get(0).getPixel(i);
//				}
//			}
//		}
//		requiresChecking = false;
//		return changedColumns;
//	}
//	
//	private boolean checkIndex(int index) {
//		for(int iterator = 1; iterator < possibleSolutions.size(); iterator++) {
//			if(!possibleSolutions.get(0).compareIndex(possibleSolutions.get(iterator), index)) {
//				return false;
//			}	
//		}
//		return true;
//	}
//	
//	
//	public void printRow() {
//		for(int i = 0; i < length; i++) {
//			if(getPixel(i) == null) {
//				System.out.print("?");
//			}else {
//				if(getPixel(i)) {
//					System.out.print("X");
//				}else {
//					System.out.print(".");
//				}
//			}
//		}
//		System.out.print("\n");
//	}
//}

/*
 * Implementation 1
 * works, but exceeds required memory limit of 1024mb
 * possible cause is the use of bytes to safe the states of pixels or the use of ArrayLists for saving those states 
 */

//package java.wip;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class YesYesItsNonograms {
//
//	public static void main(String[] args) {
//		Scanner inputScanner = new Scanner(System.in);
//		int rowCount = inputScanner.nextInt();
//		int columnCount = inputScanner.nextInt();
//		ArrayList<Row> rows = new ArrayList<Row>();
//		ArrayList<Row> columns = new ArrayList<Row>();
//		for(int i = 0; i < rowCount; i++) {
//			int sequenceCount = inputScanner.nextInt();
//			ArrayList<Integer> blackPixelSequences = new ArrayList<Integer>();
//			for(int j = 0; j < sequenceCount; j++) {
//				blackPixelSequences.add(inputScanner.nextInt());
//			}
//			rows.add(new Row(blackPixelSequences, columnCount));
//		}
//		for(int i = 0; i < columnCount; i++) {
//			int sequenceCount = inputScanner.nextInt();
//			ArrayList<Integer> blackPixelSequences = new ArrayList<Integer>();
//			for(int j = 0; j < sequenceCount; j++) {
//				blackPixelSequences.add(inputScanner.nextInt());
//			}
//			columns.add(new Row(blackPixelSequences, rowCount));
//		}
//		inputScanner.close();
//
//		boolean continueChecking = true;
//		while(continueChecking) {
//			continueChecking = false;
//			for(int i = 0; i < rowCount; i++) {
//				if(rows.get(i).getCheckingRequired()) {
//					ArrayList<Integer> changedColumns = rows.get(i).check();
//					if(!changedColumns.isEmpty()) {
//						continueChecking = true;
//						for(int j = 0; j < changedColumns.size(); j++) {
//							columns.get(changedColumns.get(j)).setPixel(i, rows.get(i).getPixel(changedColumns.get(j)));
//							columns.get(changedColumns.get(j)).setCheckingRequired();
//						}
//					}
//				}
//			}
//			
//			for(int i = 0; i < columnCount; i++) {
//				if(columns.get(i).getCheckingRequired()) {
//					ArrayList<Integer> changedRows = columns.get(i).check();
//					if(!changedRows.isEmpty()) {
//						continueChecking = true;
//						for(int j = 0; j < changedRows.size(); j++) {
//							rows.get(changedRows.get(j)).setPixel(i, columns.get(i).getPixel(changedRows.get(j)));
//							rows.get(changedRows.get(j)).setCheckingRequired();
//						}
//					}
//				}
//			}
//		}
//		
//		for(int i = 0; i < rows.size(); i++) {
//			rows.get(i).printRow();
//		}
//		
//	}	
//}
//
//class SequenceGenerator {
///*
// * This class is responsible for creating possible sequences of pixels for a given row or column in the whole array.
// */
//	
////Attributes	
//	//list of separate sequences of black pixels, separated by at least one white pixel
//	private ArrayList<Integer> blackPixelSequences;
//	//total length of the sequence counting all black and white pixels
//	private int totalSequenceLength;
//	//number of "non movable" pixels. these are all black pixels and one white pixel in between
//	private int numberOfFixedPixels;
//	
////Constructor	
//	public SequenceGenerator(ArrayList<Integer> blackPixelSequences, int totalSequenceLength) {
//		//initialize list of sequences of black pixels
//		this.blackPixelSequences = new ArrayList<Integer>();
//		//populate list of sequences of black pixels
//		this.blackPixelSequences.addAll(blackPixelSequences);
//		//set total length of pixel sequence
//		this.totalSequenceLength = totalSequenceLength;
//		//initialize count of fixed pixels with count of necessary white pixels
//		this.numberOfFixedPixels = this.blackPixelSequences.size() - 1;
//		//add all black pixels to count
//		for(int i = 0; i < this.blackPixelSequences.size(); i++) {
//			numberOfFixedPixels += this.blackPixelSequences.get(i);
//		}
//	}
//
//	private ArrayList<ArrayList<Integer>> createPossibleWhitePixelPlacements(int unusedPixels, int remainingPositions){
//		ArrayList<ArrayList<Integer>> listOfNumberSequences = new ArrayList<ArrayList<Integer>>();
//		if(remainingPositions > 1) {
//			for(int i = 0; i <= unusedPixels; i++) {
//				ArrayList<ArrayList<Integer>> listOfFollowingSequences = createPossibleWhitePixelPlacements(unusedPixels - i, remainingPositions - 1);
//				for(int j = 0; j < listOfFollowingSequences.size(); j++) {
//					ArrayList<Integer> newSequence = new ArrayList<Integer>();
//					newSequence.add(i);
//					newSequence.addAll(listOfFollowingSequences.get(j));
//					listOfNumberSequences.add(newSequence);
//				}
//			}
//		}else {
//			ArrayList<Integer> newSequence = new ArrayList<Integer>();
//			newSequence.add(unusedPixels);
//			listOfNumberSequences.add(newSequence);
//		}
//		return listOfNumberSequences;
//	}
//	
//	public ArrayList<PixelSequence> createListOfPixelSequences(){
//		ArrayList<ArrayList<Integer>> listOfPossibleWhitePixelPlacements = createPossibleWhitePixelPlacements(totalSequenceLength - numberOfFixedPixels, blackPixelSequences.size()+1);
//		ArrayList<PixelSequence> pixelSequences = new ArrayList<PixelSequence>();
//		for(int i = 0; i < listOfPossibleWhitePixelPlacements.size(); i++) {
//			ArrayList<Integer> whitePixelSequences = listOfPossibleWhitePixelPlacements.get(i);
//			ArrayList<Byte> pixels = new ArrayList<Byte>();
//			int numberOfWhiteSequences = whitePixelSequences.size();
//			int numberOfBlackSequences = blackPixelSequences.size();
//			//add first white sequence to pixel sequence
//			for(int j = 0; j < whitePixelSequences.get(0); j++) {
//				pixels.add((byte) 2);
//			}
//			//add all but last black and white sequences
//			for(int j = 1; j < numberOfWhiteSequences - 1; j++) {
//				for(int k = 0; k < blackPixelSequences.get(j - 1); k++) {
//					pixels.add((byte) 1);
//				}
//				for(int k = 0; k < whitePixelSequences.get(j) + 1; k++) {
//					pixels.add((byte) 2);
//				}
//			}
//			//add last black sequence
//			for(int j = 0; j < blackPixelSequences.get(numberOfBlackSequences - 1); j++) {
//				pixels.add((byte) 1);
//			}
//			//add last white sequence
//			for(int j = 0; j < whitePixelSequences.get(numberOfWhiteSequences - 1); j++) {
//				pixels.add((byte) 2);
//			}
//			pixelSequences.add(new PixelSequence(pixels));
//		}
//		return pixelSequences;
//	}
//}
//
//class PixelSequence {
//	//Sequence of Byte representing pixel states. 0 = unknown, 1 = black, 2 = white
//	private ArrayList<Byte> pixels;
//	
//	public PixelSequence(ArrayList<Byte> pixels) {
//		this.pixels = new ArrayList<Byte>();
//		this.pixels.addAll(pixels);
//	}
//	
//	public boolean compareIndex(PixelSequence that, int index) {
//		return this.pixels.get(index) == that.pixels.get(index);
//	}
//	
//	public byte getPixel(int index) {
//		return pixels.get(index);
//	}
//	
//	public void setPixel(int index, byte value) {
//		pixels.set(index, value);
//	}
//	
//	//checks if the sequence is compatible with a given sequence containing unknown pixels
//	public boolean getCompatibility(PixelSequence that) {
//		for(int i = 0; i < this.pixels.size(); i++) {
//			if(this.pixels.get(i) != 0 && this.pixels.get(i) != that.pixels.get(i)) {
//				return false;
//			}
//		}
//		return true;
//	}
//}
//
//class Row{
//	private PixelSequence solution;
//	private ArrayList<PixelSequence> possibleSolutions;
//	private boolean requiresChecking;
//	private int length;
//	
//	public Row(ArrayList<Integer> blackPixelSequences, int totalSequenceLength) {
//		//create solution containing only unknown pixels
//		ArrayList<Byte> solutionPixels = new ArrayList<Byte>();
//		for(int i = 0; i < totalSequenceLength; i++) {
//			solutionPixels.add((byte) 0);
//		}
//		this.solution = new PixelSequence(solutionPixels);
//		//create list of possible solutions
//		SequenceGenerator generator = new SequenceGenerator(blackPixelSequences, totalSequenceLength);
//		this.possibleSolutions = generator.createListOfPixelSequences();
//		//set checking flag
//		requiresChecking = true;
//		//set length
//		length = totalSequenceLength;
//	}
//	
//	public void setCheckingRequired() {
//		requiresChecking = true;
//	}
//	
//	public boolean getCheckingRequired() {
//		return requiresChecking;
//	}
//	
//	public void setPixel(int index, byte value) {
//		solution.setPixel(index, value);
//	}
//	
//	public byte getPixel(int index) {
//		return solution.getPixel(index);
//	}
//	
//	public ArrayList<Integer> check(){
//		ArrayList<Integer> changedColumns = new ArrayList<Integer>();
//
//		for(int i = possibleSolutions.size() - 1; i >= 0; i--) {
//			if(!solution.getCompatibility(possibleSolutions.get(i))) {
//				possibleSolutions.remove(i);
//			}
//		}
//
//		if (possibleSolutions.size() > 1) {
//			for (int index = 0; index < length; index++) {
//				if (solution.getPixel(index) == 0) {
//					if(checkIndex(index)) {
//						solution.setPixel(index, possibleSolutions.get(0).getPixel(index));
//						changedColumns.add(index);
//					}
//				}
//			} 
//		}else {
//			for(int i = 0; i < length; i++) {
//				if(!solution.compareIndex(possibleSolutions.get(0), i)) {
//					changedColumns.add(i);
//				}
//			}
//			solution = possibleSolutions.get(0);
//		}
//		requiresChecking = false;
//		return changedColumns;
//	}
//	
//	private boolean checkIndex(int index) {
//		for(int iterator = 1; iterator < possibleSolutions.size(); iterator++) {
//			if(!possibleSolutions.get(0).compareIndex(possibleSolutions.get(iterator), index)) {
//				return false;
//			}	
//		}
//		return true;
//	}
//	
//	
//	public void printRow() {
//		for(int i = 0; i < length; i++) {
//			switch(solution.getPixel(i)) {
//			case 0 : System.out.print("?"); break;
//			case 1 : System.out.print("X"); break;
//			case 2 : System.out.print("."); break;
//			}
//		}
//		System.out.print("\n");
//	}
//}