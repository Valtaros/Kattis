//This is a solution for the problem "Basic Programming 1" from open.kattis.com
//link to problem: https://open.kattis.com/problems/basicprogramming1

package main.java.wip.paused;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class BasicProgramming1 {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		int n = inputScanner.nextInt();
		byte t = inputScanner.nextByte();
		
		switch(t) {
		case 1 : case1(inputScanner); break;
		case 2 : case2(inputScanner); break;
		case 3 : case3(inputScanner); break;
		case 4 : case4(inputScanner, n); break;
		case 5 : case5(inputScanner, n); break;
		case 6 : case6(inputScanner, n); break;
		case 7 : case7(inputScanner, n); break;
		default: break;
		}
		inputScanner.close();
	}

	private static void case1(Scanner inputScanner) {
		System.out.print("7");

	}
	
	private static void case2(Scanner inputScanner) {
		int a0 = inputScanner.nextInt();
		int a1 = inputScanner.nextInt();
		if(a0 == a1) {
			System.out.print("Equal");
		}else if(a0 > a1){
			System.out.print("Bigger");
		}else {
			System.out.print("Smaller");
		}
	}
	
	private static void case3(Scanner inputScanner) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(inputScanner.nextInt());
		set.add(inputScanner.nextInt());
		set.add(inputScanner.nextInt());
		Iterator<Integer> iterator = set.iterator();
		iterator.next();
		System.out.print(iterator.next());
	}
	
	private static void case4(Scanner inputScanner, int n) {
		long sum = 0;
		for(int i = 0; i < n; i++) {
			sum += inputScanner.nextInt();
		}
		System.out.print(sum);
	}
	
	private static void case5(Scanner inputScanner, int n) {
		long sum = 0;
		for(int i = 0; i < n; i++) {
			int nextInput = inputScanner.nextInt();
			if(nextInput % 2 == 0) {
				sum += nextInput;
			}
		}
		System.out.print(sum);
	}
	
	private static void case6(Scanner inputScanner, int n) {
		for(int i = 0; i < n; i++) {
			System.out.print((char) (inputScanner.nextInt() % 26 + 97));
		}
	}
	
	private static void case7(Scanner inputScanner, int n) {
		ArrayList<Integer> array = new ArrayList<Integer>(n);
		boolean containsTooHighIndex = false;
		boolean containsLastIndex = false;
		for(int i = 0; i < n; i++) {
			int next = inputScanner.nextInt();
			array.add(next);
			if(next == n-1) {
				containsLastIndex = true;
			}
			if(next >= n) {
				containsTooHighIndex = true;
			}
		}
		if(containsLastIndex || containsTooHighIndex) {
			int arrayPointer = 0;
			while(array.get(arrayPointer) != -1) {
				int temp = arrayPointer;
				arrayPointer = array.get(arrayPointer);
				array.set(temp,-1);
				if(arrayPointer >= n) {
					System.out.print("Out");
					return;
				}
				if(arrayPointer == n-1) {
					System.out.print("Done");
					return;
				}
			}
		}
		System.out.print("Cyclic");
	}
	
	
}
