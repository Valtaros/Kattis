package main.java.solved;
import java.util.Scanner;

public class Cake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input_scanner = new Scanner(System.in);
		
		//	read parameters
		int p = input_scanner.nextInt();	//	dimension p of cake
		int q = input_scanner.nextInt();	//	dimension q of cake
		int n = input_scanner.nextInt();	//	number of roses n
		input_scanner.nextLine();			//	go to next line
		
		//	create cake
		int[][] cake = new int[p][q+1];					//	initialize cake with additional column for sum of roses in row
		for(int i = 0; i < n; i++) {					//	iterate for n roses
			int p_rose = input_scanner.nextInt() - 1;	//	read p-coordinate of rose
			int q_rose = input_scanner.nextInt() - 1;	//	read q-coordinate of rose
			cake[p_rose][q_rose] = 1;					//	place a rose on cake
			cake[p_rose][q]++;						//	increment row counter for roses
			input_scanner.nextLine();					//	go to next rose
		}
		input_scanner.close();							//	close input scanner, no more input expected
		
		//	initialize list of rectangles
		int[][] rectangles = new int[n][4];				//	list of all rectangles
		//	initialize counter for created rectangles	
		int	rectangles_created = 0;						//	count of created rectangles
		int rectangles_last_row = 0;					//	count of rectangles created in last checked row
		
		//	check for/count empty rows on top of cake
		int empty_rows_top = 0;							//	count of empty rows from top
		while(cake[empty_rows_top][q] == 0) {	
			empty_rows_top++;
		}
		
		//	create rectangle(s) for first row with rose(s)
		if(cake[empty_rows_top][q] == 1) {
			rectangles[rectangles_created][0] = 0;
			rectangles[rectangles_created][1] = 0;
			rectangles[rectangles_created][2] = empty_rows_top;
			rectangles[rectangles_created++][3] = q-1;
			rectangles_last_row = 1;
		}else {
			int[] rose_positions = new int[cake[empty_rows_top][q]];
			int roses_found = 0;
			for(int i = 0; roses_found < cake[empty_rows_top][q]; i++) {
				if(cake[empty_rows_top][i] == 1) {
					rose_positions[roses_found++] = i;
				}
			}
			int cake_position = 0;
			for(int i = 0; i < cake[empty_rows_top][q] - 1; i++) {
				rectangles[rectangles_created][0] = 0;
				rectangles[rectangles_created][1] = cake_position;
				rectangles[rectangles_created][2] = empty_rows_top;
				rectangles[rectangles_created++][3] = rose_positions[i];
				cake_position = rose_positions[i]+1;
			}
			rectangles[rectangles_created][0] = 0;
			rectangles[rectangles_created][1] = cake_position;
			rectangles[rectangles_created][2] = empty_rows_top;
			rectangles[rectangles_created++][3] = q-1;
			rectangles_last_row = cake[empty_rows_top][q];
		}
		
		//	iterate through remaining rows to create other rectangles
		for(int i_p = empty_rows_top + 1; i_p < p; i_p++) {
			if(cake[i_p][q] == 1) {
				rectangles[rectangles_created][0] = i_p;
				rectangles[rectangles_created][1] = 0;
				rectangles[rectangles_created][2] = i_p;
				rectangles[rectangles_created++][3] = q-1;
				rectangles_last_row = 1;
			}else if(cake[i_p][q] != 0){
				int[] rose_positions = new int[cake[i_p][q]];
				int roses_found = 0;
				for(int i = 0; roses_found < cake[i_p][q]; i++) {
					if(cake[i_p][i] == 1) {
						rose_positions[roses_found++] = i;
					}
				}
				int cake_position = 0;
				for(int i = 0; i < cake[i_p][q] - 1; i++) {
					rectangles[rectangles_created][0] = i_p;
					rectangles[rectangles_created][1] = cake_position;
					rectangles[rectangles_created][2] = i_p;
					rectangles[rectangles_created++][3] = rose_positions[i];
					cake_position = rose_positions[i]+1;
				}
				rectangles[rectangles_created][0] = i_p;
				rectangles[rectangles_created][1] = cake_position;
				rectangles[rectangles_created][2] = i_p;
				rectangles[rectangles_created++][3] = q-1;
				rectangles_last_row = cake[i_p][q];
			}else {
				for(int i = 0; i < rectangles_last_row; i++) {
					rectangles[rectangles_created -(1+i)][2]++; 
				}
			}
			
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println((rectangles[i][0]+1) +" "+(rectangles[i][1]+1) +" "+(rectangles[i][2]+1) +" "+(rectangles[i][3]+1));
		}
		System.out.print("0");
		/*
		if(n != 0) {
			System.out.print("0");
		}else {
			System.out.print((p*q));
		}
		*/
	}

}
