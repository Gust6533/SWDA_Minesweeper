
public class HighScoreManager {
	private int list[];
	private int size = 100;
	
	public HighScoreManager()
	{
		list = new int [size];
		for(int i = 0; i < size; i++)
		{
			list[i] = 0;
			System.out.println("Check Here"+list);
			list[i] = 1000000;
			//System.out.println("Check Here"+list);
		}
	}
	
	public void addHighScore(int highScore)
	{
		boolean notPlaced = true;
		int counter = 0;
		while( (notPlaced == true) && (counter < size ) )
		{
			if(highScore > list[counter] )
			{
				list[counter] = highScore;
			}
			else 
			{
				counter++;
			}
			
		}
		
	}
	
	public int[] getHighScores()
	{
		
		System.out.println("HereAlso"+list.toString());
		return list;
	}
	
}
