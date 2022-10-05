package main.java.solved;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Inflation {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		int numberOfBalloons = inputScanner.nextInt();
		TreeSet<GasCanister> canisters = new TreeSet<GasCanister>();
		for(int canisterId = 0; canisterId < numberOfBalloons; canisterId++) {
			canisters.add(new GasCanister(canisterId, inputScanner.nextDouble()));
		}
		inputScanner.close();
		
		Iterator<GasCanister> canisterIterator = canisters.iterator();
		double maxInflation = 1;
		boolean isPossible = true;
		for(double balloonVolume = 1; balloonVolume <= numberOfBalloons && isPossible; balloonVolume++) {
			GasCanister nextCanister = canisterIterator.next();
			double filledVolume = nextCanister.getVolume()/balloonVolume;
			if(filledVolume > 1) {
				isPossible = false;
			}else if(filledVolume < maxInflation){
				maxInflation = filledVolume;
			}
		}
		if(isPossible) {
			System.out.print(maxInflation);
		}else {
			System.out.print("impossible");
		}
	}
}

class GasCanister implements Comparable<GasCanister>{
	private int id;
	private double volume;
	
	public GasCanister(int id, double volume) {
		this.id = id;
		this.volume = volume;
	}
	
	public int getId() {
		return this.id;
	}
	
	public double getVolume() {
		return this.volume;
	}

	@Override
	public int compareTo(GasCanister that) {
		if(this.volume > that.volume) {
			return 1;
		}else if(this.volume < that.volume){
			return -1;
		}else {
			if(this.id > that.id) {
				return 1;
			}else if(this.id < that.id){
				return -1;
			}else {
				return 0;
			}
		}
	}
	
	public boolean equals(GasCanister that) {
		return this.id == that.id;
	}
}