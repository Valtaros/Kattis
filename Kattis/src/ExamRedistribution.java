import	java.util.Scanner;
import	java.util.TreeSet;
import	java.util.Iterator;

class	Room
implements	Comparable<Room>
{
	//	number of room (i) and number of students (s) 
	byte	i	=	0;
	byte	s	=	0;
	
	//	Constructor
	public			Room( byte i , byte s )
	{
		this.i	=	i;
		this.s	=	s;
	}
	
	//	compare method implementation
	public	int		compareTo(Room that)
	{
		int	s	=	(int)(this.s - that.s);
		if(s == 0)
		{
			s	=	(int)(that.i - this.i);
		}
		return s;
	}

	public boolean	equals(Room that)
	{
		return	(this.s == that.s && this.i == that.i);
	}
	
	//	get number of students (s)
	public	byte	getS()
	{
		return	this.s;
	}
	
	public	byte	getI()
	{
		return	this.i;
	}
}

public class ExamRedistribution
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner			input			=	new Scanner(System.in);
		
		//	get number of rooms
		byte			rooms_num		=	input.nextByte();
		
		//	get rooms and sum of students
		
			//	initialize list of rooms and sum
		TreeSet<Room>	rooms			=	new TreeSet<Room>();
		int				students_sum	=	0;
		
			//	add rooms to list and sum up
		for(byte i = 1 ; i <= rooms_num ; i++)
		{
			byte	students_next	=	input.nextByte();
			students_sum			=	students_sum + students_next;
			rooms.add(new Room(i, students_next));
		}
		
		//	create output
			//	check for possibility
		if( ( rooms.last().getS() * 2 ) > students_sum)
		{
			//	output if not possible
			System.out.println("impossible");
		}
		else
		{
			//	create possible output
			Iterator<Room>	iter	=	rooms.descendingIterator();
			while( iter.hasNext() )
			{
				System.out.print(iter.next().getI()+" ");
			}
		}
		
		//	end program
		input.close();
		return;
	}

}
