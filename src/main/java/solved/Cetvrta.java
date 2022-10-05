package main.java.solved;
import java.util.Scanner;

public class Cetvrta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input_scanner = new Scanner(System.in);
		int x_1 = 0;
		int x_2 = 0;
		int y_1 = 0;
		int y_2 = 0;
		int x_1_count = 1;
		int x_2_count = 0;
		int y_1_count = 1;
		int y_2_count = 0;
		
		x_1 = input_scanner.nextInt();
		y_1 = input_scanner.nextInt();
		for(int i = 0; i < 2; i++) {
			int temp = input_scanner.nextInt();
			if(temp == x_1) {
				x_1_count++;
			}else {
				x_2 = temp;
				x_2_count++;
			}
			temp = input_scanner.nextInt();
			if(temp == y_1) {
				y_1_count++;
			}else {
				y_2 = temp;
				y_2_count++;
			}
		}
		input_scanner.close();
		
		if(x_1_count == 1) {
			System.out.print(x_1);
		}else {
			System.out.print(x_2);
		}
		System.out.print(" ");
		if(y_1_count == 1) {
			System.out.print(y_1);
		}else {
			System.out.print(y_2);
		}
	}

}
