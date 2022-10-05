package main.java.solved;
import	java.util.Scanner;
import	java.util.ArrayList;

class		Queen
{
	//	position o field
	byte	pos_x;
	byte	pos_y;
	
	//	Constructor
	public	Queen(byte pos_x , byte pos_y)
	{
		this.pos_x	=	pos_x;
		this.pos_y	=	pos_y;
	}
	
	//	get functions
	public	byte	getX()
	{
		return	this.pos_x;
	}
	
	public	byte	getY()
	{
		return	this.pos_y;
	}
	
	//	check if hitting other queen
	public	boolean	collision(Queen that)
	{
		return
		(	this.pos_x == that.pos_x										//	same column
		||	this.pos_y == that.pos_y										//	same row
		||	this.pos_x - this.pos_y == that.pos_x - that.pos_y				//	same diagonal (top left -> down right)
		||	8 - this.pos_y - this.pos_x == 8 - that.pos_y - that.pos_x);	//	same diagonal (down left -> top right)
	}
}

public class EightQueens
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner				input	=	new Scanner(System.in);
		
		//	initialize list of queens
		ArrayList<Queen>	queens	=	new	ArrayList<Queen>();
		
		//	get input
		for(byte y = 0 ; y < 8 ; y++)
		{
			String			next	=	input.next();
			for(byte x = 0 ; x < 8 ; x++)
			{
				if(next.charAt(x) == '*')
				{
					queens.add( new Queen( x , y ) );
				}
			}
		}
		
		//	check number of queens
		boolean	result	=	(queens.size() == 8);
		
		//	check queen pairs for collision		
		for(byte i = 0 ; i < queens.size() && result ; i++)
		{
			for(byte j = (byte)(i+1) ; j < queens.size() && result ; j++)
			{
				result = !queens.get(i).collision(queens.get(j));
			}
		}
		
		//	output result
		if(result)
		{
			System.out.println("valid");
		}
		else
		{
			System.out.println("invalid");	
		}
		
		//	end program
		input.close();
		return;
	}

}
