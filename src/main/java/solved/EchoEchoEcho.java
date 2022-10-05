//This is a solution for the problem "Echo Echo Echo" from open.kattis.com
//link to problem: https://open.kattis.com/problems/echoechoecho
package main.java.solved;
import	java.util.Scanner;

public class EchoEchoEcho{

    public static void main(String[] args) {
        //initialize input scanner
        Scanner	inputScanner = new Scanner(System.in);
        //read input
        String input = inputScanner.nextLine();
        //close Scanner
        inputScanner.close();
        //print output
        System.out.println(input + " " + input + " " + input);
    }
}
