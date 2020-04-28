//This is a solution for the problem "Transit Woes" from open.kattis.com
//link to problem: https://open.kattis.com/problems/transitwoes
package solved;

import java.util.ArrayList;
import java.util.Scanner;

public class TransitWoes {

	public static void main(String[] args) {
		//initialize input scanner
		Scanner	inputScanner = new Scanner(System.in);
		//get input
		int startTime = inputScanner.nextInt();
		int classTime = inputScanner.nextInt();
		int numberOfRoutes = inputScanner.nextInt();
		ArrayList<Integer> walkingTimes = new ArrayList<Integer>(numberOfRoutes + 1);
		for(int i = 0; i < numberOfRoutes + 1; i++) {
			walkingTimes.add(inputScanner.nextInt());
		}
		ArrayList<Integer> busDrivingTimes = new ArrayList<Integer>(numberOfRoutes);
		for(int i = 0; i < numberOfRoutes; i++) {
			busDrivingTimes.add(inputScanner.nextInt());
		}
		ArrayList<Integer> busStartTimes = new ArrayList<Integer>(numberOfRoutes);
		for(int i = 0; i < numberOfRoutes; i++) {
			busStartTimes.add(inputScanner.nextInt());
		}
		//close Scanner
		inputScanner.close();
		
		int totalTravelTime = startTime;
		for(int routeIndex = 0; routeIndex < numberOfRoutes; routeIndex++) {
			//walk to next station
			totalTravelTime += walkingTimes.get(routeIndex);
			//wait for bus
			if(totalTravelTime % busStartTimes.get(routeIndex) != 0) {
				totalTravelTime += (busStartTimes.get(routeIndex) - (totalTravelTime % busStartTimes.get(routeIndex)));
			}
			//travel with bus
			totalTravelTime += busDrivingTimes.get(routeIndex);
		}
		//walk to class
		totalTravelTime += walkingTimes.get(numberOfRoutes);
		//check arrival
		if(totalTravelTime <= classTime) {
			System.out.print("yes");
		}else {
			System.out.print("no");
		}
		
	}

}
