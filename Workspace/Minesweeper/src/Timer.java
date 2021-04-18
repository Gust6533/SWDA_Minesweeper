

public class Timer {
	private long current_time; //in milliseconds
	private long totalTime; //in milliseconds
	
	public Timer()
	{
		totalTime = 0;
	}
	
	public void startTimer()
	{
		current_time = System.currentTimeMillis();
	}
	
	public void stopTimer()
	{
		long i = System.currentTimeMillis();
		System.out.println(i);
		totalTime += i - current_time;
		System.out.println(totalTime);
	}
	
	//returns in seconds of total timer the timer was running
	public long getTime() 
	{
		System.out.println(totalTime);
		return totalTime / 1000;
	}
	
}
