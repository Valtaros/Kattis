package wip;
/*
 * Problem seems to be solved, Kattis returns time limit exceeded
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

class GridPosition implements Comparable<GridPosition>{
	//	Attributes (Coordinates)
	public int x;
	public int y;
	
	//	Constructor with given values
	public GridPosition(int x,  int y) {
		this.x = x;
		this.y = y;
	}

	//	Constructor by copy
	public GridPosition(GridPosition that) {
		this.x = that.x;
		this.y = that.y;
	}
	
	//	neighbor methods
	public GridPosition right() {
		GridPosition neighbor = new GridPosition(this.x+1, this.y);
		return neighbor;
	}
	
	public GridPosition left() {
		GridPosition neighbor = new GridPosition(this.x-1, this.y);
		return neighbor;
	}
	
	public GridPosition up() {
		GridPosition neighbor = new GridPosition(this.x, this.y-1);
		return neighbor;
	}
	
	public GridPosition down() {
		GridPosition neighbor = new GridPosition(this.x+1, this.y+1);
		return neighbor;
	}
	//	method implementation of Comparable interface
	public int compareTo(GridPosition that) {
		if(this.x > that.x) {
			return 1;
		}else if(this.x < that.x) {
			return -1;
		}else {
			if(this.y > that.y) {
				return 1;
			}else if(this.y < that.y) {
				return -1;
			}else {
				return 0;
			}
		}
	}
	
	public boolean equals(GridPosition that) {
		if(this.x == that.x && this.y == that.y) {
			return true;
		}else {
			return false;
		}
	}
}

public class RobotsOnAGrid {

	static int walk_rd(int grid_size, String[] grid, int pos_x, int pos_y) {
		// check for goal
		if(pos_x +1 == grid_size && pos_y +1 == grid_size) {
			return 1;
		}
		
		// initialize counter for walks
		int count = 0;
		// try walking right
		if(pos_x +1 < grid_size) {
			if(grid[pos_y].charAt(pos_x+1) == '.') {
				pos_x++;
				count += walk_rd(grid_size, grid, pos_x, pos_y);
				pos_x--;
			}
		}
		// try walking down
		if(pos_y +1 < grid_size) {
			if(grid[pos_y+1].charAt(pos_x) == '.') {
				pos_y++;
				count += walk_rd(grid_size, grid, pos_x, pos_y);
			}
		}
		
		return count;
	}
	
	static String walk_lu(int grid_size, String[] grid) {
		
		ArrayList	<GridPosition> queue 			= new ArrayList	<GridPosition>();
		TreeSet		<GridPosition> not_connected 	= new TreeSet	<GridPosition>();
		for(int x = 0; x < grid_size; x++) {
			for(int y = 0; y < grid_size; y++) {
				if(grid[y].charAt(x) == '.') {
					not_connected	.add	(new GridPosition(x, y));
				}
			}
		}
		GridPosition start	= new GridPosition(0,0);
		GridPosition finish	= new GridPosition(grid_size -1, grid_size -1);
		not_connected	.remove	(start);
		queue			.add	(start);
		
		while(!queue.isEmpty()) {
			GridPosition check = new GridPosition(queue.get(0));
			GridPosition neighbor = check.right();
			if(neighbor.equals(finish)) {
				return "THE GAME IS A LIE";
			}else {
				if(not_connected.contains(neighbor)) {
					not_connected.remove(neighbor);
					queue.add(neighbor);
				}
			}
			neighbor = check.down();
			if(neighbor.equals(finish)) {
				return "THE GAME IS A LIE";
			}else {
				if(not_connected.contains(neighbor)) {
					not_connected.remove(neighbor);
					queue.add(neighbor);
				}
			}
			neighbor = check.left();
			if(neighbor.equals(finish)) {
				return "THE GAME IS A LIE";
			}else {
				if(not_connected.contains(neighbor)) {
					not_connected.remove(neighbor);
					queue.add(neighbor);
				}
			}
			neighbor = check.up();
			if(neighbor.equals(finish)) {
				return "THE GAME IS A LIE";
			}else {
				if(not_connected.contains(neighbor)) {
					not_connected.remove(neighbor);
					queue.add(neighbor);
				}
			}
			queue.remove(0);
		}
		return "INCONCEIVABLE";
	}
	
	public static void main(String[] args) {
	
		// initialize Scanner
		Scanner input_scanner = new Scanner(System.in);
		// read grid size
		int grid_size = input_scanner.nextInt();
		input_scanner.nextLine();
		// initialize grid
		String[] grid = new String[grid_size];
		// read grid
		for(int i = 0; i < grid_size; i++) {
			grid[i] = input_scanner.nextLine();
		}
		// close Scanner
		input_scanner.close();
		// initialize position of robot
		int pos_x = 0;
		int pos_y = 0;
		
		int number_of_rd_walks = (walk_rd(grid_size, grid, pos_x, pos_y));
		if(number_of_rd_walks > 0) {
			System.out.println(number_of_rd_walks);
		}else {
			System.out.print(walk_lu(grid_size, grid));
		}
	
		
	}
}


