//This is a solution for the problem "Bit by Bit" from open.kattis.com
//link to problem: https://open.kattis.com/problems/bitbybit
package main.java.solved;

import java.util.Scanner;

public class BitByBit {
	private static char[] bits;
	
	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		int lines;
		while((lines = inputScanner.nextInt()) != 0) {
			reset();
			for(int i = 0; i < lines; i++) {
				String line = inputScanner.next();
				switch(line) {
				case "SET": set(inputScanner.nextInt()); break;
				case "CLEAR": clear(inputScanner.nextInt()); break;
				case "OR": or(inputScanner.nextInt(), inputScanner.nextInt()); break;
				case "AND" : and(inputScanner.nextInt(), inputScanner.nextInt()); break;
				}
			}
			print();
		}

		//close Scanner
		inputScanner.close();
	}
	
	private static void reset() {
		bits = new char[32];
		for(int i = 0; i < 32; i++) {
			bits[i] = '?';
		}
	}
	
	private static void set(int index) {
		bits[index] = '1';
	}
	
	private static void clear(int index) {
		bits[index] = '0';
	}
	
	private static void or(int index1, int index2) {
		if(bits[index1] == '1' || bits[index2] == '1') {
			bits[index1] = '1';
		}else if(bits[index1] == '0' && bits[index2] == '0'){
			bits[index1] = '0';
		}else {
			bits[index1] = '?';
		}
	}
	
	private static void and(int index1, int index2) {
		if(bits[index1] == '1' && bits[index2] == '1') {
			bits[index1] = '1';
		}else if(bits[index1] == '0' || bits[index2] == '0') {
			bits[index1] = '0';
		}else {
			bits[index1] = '?';
		}
	}

	private static void print() {
		for(int i = 31; i >=0; i--) {
			System.out.print(bits[i]);
		}
		System.out.print("\n");
	}
}
