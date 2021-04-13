

public class Manager {
	private static diffculty currentDifficulty = diffculty.Meduim;
	private static Board gameBoard;
	private static Artist artist;
	private static Timer time; 
	
	public Manager(){
		gameBoard = new Board(currentDifficulty);
		time = new Timer();
		artist = new Artist(gameBoard);
		
		time.startTimer();
	}
	
	public static void restart()
	{
		gameBoard = new Board(currentDifficulty);
		artist.redraw(gameBoard);
		time.startTimer();
	}
	
	public static void setDifficulty(diffculty dif)
	{
		currentDifficulty = dif;
		Manager.restart();
	}
	
	 public static void buttonPress(int x, int y)
	{
		 //restart timer as soon as the game is processing again
		 time.startTimer();
		 
		 //cover calling the game board out of bounds
		if (x < 0 || y < 0 || x >= gameBoard.getsize() || y >= gameBoard.getsize())
		{
			return ;
		}
		else if(gameBoard.beenClicked(x, y))
		{
			return ;
		}
		 int mines;
		//check if mine
		if ( gameBoard.isMine(x,y) == true)
		{
			artist.drawLose();
			Manager.restart();
		}
		else if(gameBoard.setClicked(x,y) == 0)
		{
			time.stopTimer();
			artist.drawWin(time.getTime());
			Manager.restart();
		}
		else
		{

			//determine number of mines around and report back
			mines = gameBoard.minesNextTo(x, y);
			artist.updateLocationNumber(x, y, mines);
			//populate all the around areas if there are no mines near
			if (mines == 0)
			{
				for (int i = x - 1; i <= x + 1; i++)
				{
					for (int j = y - 1; j <= y + 1; j++)
					{
						Manager.buttonPress(i, j);
					}
				}
				
			}


			
		}
	}
	
	
	
	 

	
	public static void main(String[] args)
	{
		Manager m = new Manager();
		
	}

	public static void StopTimer() {
		time.stopTimer();
		
	}
	
	 
}
