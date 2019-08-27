package solved;
import	java.util.Scanner;
import	java.util.ArrayList;

class	Rectangle
{
	//	variables
	int	x1	=	0;
	int	y1	=	0;
	int	x2	=	0;
	int	y2	=	0;
	
	//	constructors
	public			Rectangle(int x1, int y1, int x2, int y2)
	{
		this.x1	=	x1;
		this.y1	=	y1;
		this.x2	=	x2;
		this.y2	=	y2;
	}
	
	//	check for hit
	public	boolean	hit(int x, int y)
	{
		return (x >= this.x1 && x <= this.x2 && y >= this.y1 && y <= this.y2);
	}
}

class	Circle
{
	//	variables
	int	x	=	0;
	int	y	=	0;
	int	r	=	0;
	
	//	constructors
	public			Circle(int x, int y, int r)
	{
		this.x	=	x;
		this.y	=	y;
		this.r	=	r;
	}
	
	//	check for hit
	public	boolean	hit(int x, int y)
	{
		return (Math.sqrt( ( (this.x-x) * (this.x-x) ) + ( (this.y-y) * (this.y-y) ) ) <= this.r);
		
	}
	
}
public class HittingTheTargets
{

	public static void main(String[] args)
	{
		//	initialize input scanner
		Scanner					input		=	new Scanner(System.in);
		
		//	get number of targets
		byte					target_num	=	input.nextByte();
			
		//	initialize target list
		ArrayList<Rectangle>	rectangles	=	new ArrayList<Rectangle>(target_num);
		ArrayList<Circle>		circles		=	new ArrayList<Circle>(target_num);
		
		//	get targets
		for(int i = 0 ; i < target_num ; i++)
		{
			//	check if circle/rectangle
			if(input.next().equals("circle"))
			{
				//	add circle to list
				circles.add( new Circle( input.nextInt() , input.nextInt() , input.nextInt() ) );
			}
			else
			{
				//	add rectangle to list
				rectangles.add( new Rectangle( input.nextInt() , input.nextInt() , input.nextInt() , input.nextInt() ) );	
			}
		}
		
		//	get number of shots
		byte shots	=	input.nextByte();
		
		//	check shots
		for(int i = 0 ; i < shots ; i++)
		{
			//	get shot coordinates
			int		shot_x	=	input.nextInt();
			int		shot_y	=	input.nextInt();
			
			//	initialize number of hits
			byte	hits	=	0;
			
			//	check rectangles for hits
			for(int j = 0 ; j < rectangles.size() ; j++)
			{
				if(rectangles.get(j).hit(shot_x, shot_y))
				{
					hits++;
				}
			}
			
			//	check circles for hits
			for(int j = 0 ; j < circles.size() ; j++)
			{
				if(circles.get(j).hit(shot_x, shot_y))
				{
					hits++;
				}
			}
			
			//	output number of hits
			System.out.println(hits);
		}
		
		//	end program
		input.close();
		return;
	}

}
