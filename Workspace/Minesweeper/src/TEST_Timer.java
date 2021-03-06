import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.junit.jupiter.api.Test;

class TEST_Timer {
  //Note for testing there is a mine at 1,1
	
	@Test
	void defaultTimer() 
	{
		Timer time = new Timer();
		assertEquals(0, time.getTime(), "Default Time of 0");
		
	}
	
	@Test
	void RandomTimer() 
	{
		Timer time = new Timer();
		 Random rand = new Random();
		assertTrue(time.getTime() != rand.nextLong() );
		
	}
		
	@Test
	void UnequalTimer() 
	{
		Timer time = new Timer();
		assertFalse("deafult time is 0", (time.getTime()>1));		
	}
		 
}

