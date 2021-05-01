import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TEST_HighScoreManager {
//Note for testing there is a mine at 1,1
	
	@Test
	void defaultHighScores() 
	{
		HighScoreManager highScore = new HighScoreManager();		
		int list[] =  highScore.getHighScores();
		assertEquals(1000000, list[0], "default High scores");
	}
	
	@Test
	void RandomScores() 
	{
		HighScoreManager highScore = new HighScoreManager();		
		int list[] =  highScore.getHighScores();
		assertEquals(1000000, list[2], "random scores");
	}
	
	@Test
	void UneuqalScores() 
	{
		HighScoreManager highScore = new HighScoreManager();		
		int list[] =  highScore.getHighScores();
		assertFalse("scores not equal", (list[0]==100));		
	}
}
