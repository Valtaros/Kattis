package main.java.wip.paused;
import	java.util.Scanner;
import	java.util.Arrays;

public class Escape {
	public static class Corridor{
		public	int		a;
		public	int		b;
		public	Corridor	(int i, int j) 	{
			if(i<j) {
				a = i;
				b = j;
			}else {
				a = j;
				b = i;
			}
		}
		public	Corridor	() 				{
			a = 0;
			b = 0;
		}
	}

	public static class Branch{
		private int		id_room;
		private int		id_parent;
		private int[]	id_children;
		private int		cost;
		private int		value;
		private boolean	exit 		= false;
		private boolean	exit_path 	= false;
		private boolean used		= false;
		private boolean	useable		= false;
		private boolean	cut			= false;
		
		public			Branch			(int id_room, int id_parent, int[] id_children, int cost) {
			this.id_room 		= id_room;
			this.id_parent 		= id_parent;
			this.id_children 	= Arrays.copyOf(id_children, id_children.length);
			this.cost 			= cost;
		}
		public			Branch			() 						{}
		public	int		getId_room		() 						{return id_room;}
		public	int		getId_parent	() 						{return id_parent;}
		public	int[]	getId_children	()						{return Arrays.copyOf(id_children, id_children.length);}
		public	int		getCost			()						{return cost;}
		public	int		getValue		()						{return value;}
		public	boolean	getExit			()						{return exit;}
		public	boolean	getExit_path	()						{return exit_path;}
		public	boolean	getUsed			()						{return used;}
		public	boolean	getUseable		()						{return useable;}
		public	boolean	getCut			()						{return cut;}
		public	void	setId_room		(int 		id_room) 	{this.id_room 		= id_room; 											return;}
		public	void	setId_parent	(int 		id_parent) 	{this.id_parent 	= id_parent; 										return;}
		public	void	setId_children	(int[] 		id_children){this.id_children 	= Arrays.copyOf(id_children, id_children.length);	return;}
		public	void	setCost			(int 		cost) 		{this.cost 			= cost; 											return;}
		public	void	setValue		(int 		value)	 	{this.value 		= value; 											return;}
		public	void	setExit			(boolean 	exit)	 	{this.exit 			= exit; 											return;}
		public	void	setExit_path	(boolean 	exit_path) 	{this.exit_path 	= exit_path; 										return;}
		public	void	setUsed			(boolean	used)		{this.used			= used;												return;}
		public	void	setUseable		(boolean 	useable) 	{this.useable 		= useable; 											return;}
		public	void	setCut			(boolean 	cut)	 	{this.cut 			= cut; 												return;}
		
		
	}
	public static class Tree{
		private	int[]		rooms;
		private	int			exit;
		private	Corridor[]	corridors;
		
		private	Branch[]	branches;
		
		public	Tree(int[] rooms, int exit, Corridor[] corridors) {
			this.rooms		= Arrays.copyOf(rooms , rooms.length);
			this.exit		= exit;
			this.corridors	= Arrays.copyOf(corridors, corridors.length);
			branches 		= new Branch[rooms.length];
		}
		
		public	void 	createBranch	(int[] rooms, int room_exit, Corridor[] corridors) {
			
		}
		
		public	void	cutBranch		() 	{};
		public	void	calcBranchValue	()	{};
		
		
	}

public static void main(String[] args) {
	//	initiation		
	Scanner sc = new Scanner(System.in);
	
	int tests;
	
	//	read number of test cases + go through test cases
	for(tests = sc.nextInt(); tests > 0; tests--) {
		
		//	initialize Rooms
			int[]	rooms 		= new int[sc.nextInt()];
			int 	room_exit	= sc.nextInt();
		
		//	read Rooms
			for(int i = 0 ; i < rooms.length ; i++) {
				rooms[i] = sc.nextInt();
			}
		
		//	initialize Edges
			Corridor[] corridors = new Corridor[rooms.length-1];
		
		//	read Edges
			for(int i = 0; i<rooms.length-1; i++) {
				corridors[i] = new Corridor((sc.nextInt() - 1) , (sc.nextInt() - 1));
			}
		
		//	create Tree through Branches
		//	search for exit path
			//	mark rooms as essential?
		//	cut negative Leafs recursively
		//	walk through Tree
			//	can advance exit path
				//	pay HP cost
				//	update exit path progress
				//	if exit : end (return escaped)
				//	not exit : recursively call walkTroughTree 
			//	can advance trough cheapest branch
				//	update HP
				//	update available branch list
				//	recursively call walkTroughTree
			//	can not advance
				//	return trapped to parent call
		//	end (return trapped)
	}
	//end programm
	sc.close();
	return;
}
}
