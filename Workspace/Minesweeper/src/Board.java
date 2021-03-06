
import java.util.Random;



public class Board {
	private Boolean[][] mines; //location of the mines
	private int size; //the size of the board
	private Boolean[][] hasBeenClicked; //If the space has been clicked or not
	private int unclickedSpaces; // Number of Mines left on the field

	public Board()
	{
		//set to default of normal
		this(diffculty.Meduim);
	}
	
	//contrustor for testing only that has 2 mines, and medium dif
	// mines at 1,1 & 1,2
	public Board (  int mine )
	{
		int i, j;
		int minesPlaces = 0;
		

		size = 20;
		mines = new Boolean [size][size];		
		hasBeenClicked = new Boolean [size][size];	
		minesPlaces = 13;	

	
		unclickedSpaces = (size * size) - minesPlaces;
		//set up game board 
		//set everything to false
		for(i = 0; i < size; i ++)
		{
			for(j = 0; j < size; j ++)
			{
				hasBeenClicked[i] [j] = false;
				mines[i] [j] = false;
			}
			
		}
		
		mines[1][1] = true;
		mines[1][2] = true;
		
	}
	
	public Board( diffculty dif )
	{
		int i, j;
		int minesPlaces = 0;
		
		if(dif == diffculty.Easy)
		{
			size = 10;
			mines = new Boolean [size][size];	
			hasBeenClicked = new Boolean[size][size];	
			minesPlaces = 8;	
		}
		else if ( dif == diffculty.Meduim )
		{
			size = 20;
			mines = new Boolean [size][size];		
			hasBeenClicked = new Boolean [size][size];	
			minesPlaces = 13;	
		}
		else
		{
			size = 30;
			mines = new Boolean[size][size];		
			hasBeenClicked = new Boolean [size][size];	
			minesPlaces = 20;		
		}
	
		unclickedSpaces = (size * size) - minesPlaces;
		//set up game board 
		//set everything to false
		for(i = 0; i < size; i ++)
		{
			for(j = 0; j < size; j ++)
			{
				hasBeenClicked[i] [j] = false;
				mines[i] [j] = false;
			}
			
		}
		
		// place mines into board randomly, making sure there is not already a mine there
		Random rand = new Random();
		mines[1][1] = true; // TODO remove -- placing for debugging of knowing where a mine is
		while(minesPlaces > 0)
		{
			i = rand.nextInt(size);
			j = rand.nextInt(size);
			if (mines[i][j] == false )
			{
				System.out.println("Mine at: " + Integer.toString(i) + "," + Integer.toString(j) );
				mines[i][j] = true;
				minesPlaces --;
			}
		} 
		
	}
	
	//returns if the spot on the board is a mine or not
	public Boolean isMine(int x, int y) 
	{
		if (x < 0 || y < 0 || x >= size || y >= size)
		{
			return false;
		}
		return mines[x][y];
		
	}
	
	//returns if the spot has been clicked or not
	public Boolean beenClicked(int x, int y)
	{
		if (x < 0 || y < 0 || x >= size || y >= size)
		{
			return false;
		}
		return hasBeenClicked[x][y];
		
	}
	
	//set the item to clicked and then returns if there is a mine there to end the game or not 
	public int setClicked(int x, int y)
	{
		if(hasBeenClicked[x][y] == false)
		{
			unclickedSpaces--;
		}
		hasBeenClicked[x][y] = true;
		
		return unclickedSpaces;
		
	}
	
	
	public int getsize()
	{
		return size;
	}
	
	public int minesNextTo(int x, int y)
	{
		int num = 0;
		//determine x and y coords to do the search on
		System.out.println("Checking at: " + Integer.toString(x) + "," + Integer.toString(y) );
		for (int i = x - 1; i <= x + 1; i++)
		{
			for (int j = y - 1; j <= y + 1; j++)
			{
				if(this.isMine(i,j) == true)
				{
					num++;
				}
			}
		}
		return num;
	}
}
