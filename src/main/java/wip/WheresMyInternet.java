package main.java.wip;
/*
1. VERSION - TIME LIMIT EXCEEDED
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

class House{
	int number;
	ArrayList<Integer> connections;
	
	public House(int number) {
		this.number = number;
		connections = new ArrayList<Integer>(0);
	}
	
	public void connect(int number) {
		connections.add(number);
	}
	
	public void check(House[] houses, TreeSet<Integer> house_numbers) {
		house_numbers.remove(this.number);
		for(int i = 0; i < this.connections.size(); i++) {
			if(house_numbers.contains(this.connections.get(i))) {
				houses[this.connections.get(i)].check(this.number, houses, house_numbers);
			}
		}
	}
	
	public void check(int number, House[] houses, TreeSet<Integer> house_numbers) {
		house_numbers.remove(this.number);
		for(int i = 0; i < this.connections.size(); i++) {
			if(house_numbers.contains(this.connections.get(i))) {
				houses[this.connections.get(i)].check(this.number, houses, house_numbers);
			}
		}
	}
}

public class WheresMyInternet {
	
	
	
	public static void main(String[] args) {
		Scanner input_scanner = new Scanner(System.in);
		
		int n = input_scanner.nextInt();
		int m = input_scanner.nextInt();
		
		House[] houses = new House[n];
		TreeSet<Integer> house_numbers = new TreeSet<Integer>();
		
		for(int i = 0; i < n; i++) {
			houses[i] = new House(i);
			house_numbers.add(i);
		}
		
		for(int i = 0; i < m; i++) {
			int connector_1 = input_scanner.nextInt() - 1;
			int connector_2 = input_scanner.nextInt() - 1;
			houses[connector_1].connect(connector_2);
			houses[connector_2].connect(connector_1);
		}
		
		houses[0].check(houses, house_numbers);
		
		
		
		if(house_numbers.isEmpty()) {
			System.out.print("Connected");
		}else {
			Iterator<Integer> iter = house_numbers.iterator();
			while(iter.hasNext()) {
				System.out.println((iter.next()+1));
			}
		}
	}
}
*/

/*
2. VERSION - TIME LIMIT EXCEEDED

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

class House implements Comparable<House>{
	int number;
	TreeSet<Integer> connections;
	
	public House(int number) {
		this.number = number;
		connections = new TreeSet<Integer>();
	}
	
	public House(int number, int connection) {
		this.number = number;
		this.connections = new TreeSet<Integer>();
		this.connections.add(connection);
	}
	
	public void activate(TreeSet<Integer> houses_not_connected, TreeSet<House> houses_with_dead_connection) {
		Iterator<Integer> iterator = this.connections.iterator();
		while(iterator.hasNext()) {
			int temp = iterator.next();
			houses_not_connected.remove(temp);
			houses_with_dead_connection.remove(this);
			if(houses_with_dead_connection.contains(new House(temp))) {
				houses_with_dead_connection.floor(new House(temp)).activate(houses_not_connected, houses_with_dead_connection);
			}
		}
	}
	
	public int	compareTo(House that) {
		if(this.number < that.number) {
			return -1;
		}
		if(this.number > that.number) {
			return 1;
		}
		return 0;
	}
	
	public boolean equals(House that) {
		return (this.number == that.number);
	}
}

public class WheresMyInternet {
	
	
	
	public static void main(String[] args) {
		Scanner input_scanner = new Scanner(System.in);
		
		int n = input_scanner.nextInt();
		int m = input_scanner.nextInt();
		
		TreeSet<Integer> houses_not_connected = new TreeSet<Integer>();
		TreeSet<House> houses_with_dead_connection = new TreeSet<House>();
		for(int i = 2; i <= n; i++) {
			houses_not_connected.add(i);
		}
		
		for(int i = 0; i < m; i++) {
			int x_1 = input_scanner.nextInt();
			int x_2 = input_scanner.nextInt();
			
			if(!houses_not_connected.contains(x_1)) {
				houses_not_connected.remove(x_2);
				if(houses_with_dead_connection.contains(new House(x_2))) {
					houses_with_dead_connection.floor(new House(x_2)).activate(houses_not_connected, houses_with_dead_connection);
				}
			}
			if(!houses_not_connected.contains(x_2)) {
				houses_not_connected.remove(x_1);
				if(houses_with_dead_connection.contains(new House(x_1))) {
					houses_with_dead_connection.floor(new House(x_1)).activate(houses_not_connected, houses_with_dead_connection);
				}
			}
			if(houses_not_connected.contains(x_1) && houses_not_connected.contains(x_2)) {
				if(!houses_with_dead_connection.contains(new House(x_1))) {
					houses_with_dead_connection.add(new House(x_1, x_2));
				}else {
					houses_with_dead_connection.floor(new House(x_1)).connections.add(x_2);
				}
				if(!houses_with_dead_connection.contains(new House(x_2))) {
					houses_with_dead_connection.add(new House(x_2, x_1));
				}else {
					houses_with_dead_connection.floor(new House(x_2)).connections.add(x_1);
				}
				
			}
		}
		
		input_scanner.close();
		
		if(houses_not_connected.isEmpty()) {
			System.out.print("Connected");
		}else {
			Iterator<Integer> iterator = houses_not_connected.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
	}
}

*/

/*
3. VERSION - TIME LIMIT EXCEEDED

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;



public class WheresMyInternet {
	
	
	
	public static void main(String[] args) {
		Scanner input_scanner = new Scanner(System.in);
		
		int n = input_scanner.nextInt();
		int m = input_scanner.nextInt();
		
		ArrayList<TreeSet<Integer>> networks = new ArrayList<TreeSet<Integer>>();
		networks.add(new TreeSet<Integer>());
		networks.get(0).add(1);
		
		for(int i_1 = 0; i_1 < m; i_1++) {
			int x_1 = input_scanner.nextInt();
			int x_2 = input_scanner.nextInt();
			
			int network_id_1 = -1;
			int network_id_2 = -1;
			
			for(int i_2 = 0; i_2 < networks.size() && network_id_2 == -1; i_2++) {
				if(networks.get(i_2).contains(x_1) || networks.get(i_2).contains(x_2)) {
					networks.get(i_2).add(x_1);
					networks.get(i_2).add(x_2);
					if(network_id_1 == -1) {
						network_id_1 = i_2;
					}else {
						network_id_2 = i_2;
					}
				}
			}
			
			if(network_id_2 != -1) {
				networks.get(network_id_1).addAll(networks.get(network_id_2));
				networks.remove(network_id_2);
			}
			
			if(network_id_1 == -1) {
				networks.add(new TreeSet<Integer>());
				networks.get(networks.size()-1).add(x_1);
				networks.get(networks.size()-1).add(x_2);
			}
		}
		if(networks.get(0).size() == n) {
			System.out.print("Connected");
		}else {
			for(int i = 1; i <= n; i++) {
				if(!networks.get(0).contains(i)) {
					System.out.println(i);
				}
			}
		}
	}
}

*/

/*
4. VERSION - WRONG ANSWER
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;



public class WheresMyInternet {
	
	
	
	public static void main(String[] args) {
		Scanner input_scanner = new Scanner(System.in);
		
		int n = input_scanner.nextInt();
		int m = input_scanner.nextInt();
		
		ArrayList<Integer[]> connections = new ArrayList<Integer[]>(m);
		for(int i = 0; i < m; i++) {
			connections.add(new Integer[2]);
			connections.get(i)[0] = input_scanner.nextInt();
			connections.get(i)[1] = input_scanner.nextInt();
		}
		
		TreeSet<Integer> connected = new TreeSet<Integer>();
		for(int i = 1; i <= n; i++) {
			connected.add(i);
		}
		ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(1);
		while(!queue.isEmpty()) {
			for(int i = 0; i < connections.size(); i++) {
				if(queue.get(0) == connections.get(i)[0]) {
					queue.add(connections.get(i)[1]);
					connections.remove(i--);
				}else if(queue.get(0) == connections.get(i)[1]) {
					queue.add(connections.get(i)[0]);
					connections.remove(i--);
				}
			}
			connected.remove(queue.get(0));
			queue.remove(queue.get(0));
		}
		
		if(connected.size() == 0) {
			System.out.print("Connected");
		}else {
			Iterator<Integer> iterator = connected.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
	}
}

