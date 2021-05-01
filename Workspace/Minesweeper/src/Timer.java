

public class Timer {
	private long current_time; //in milliseconds
	private long totalTime; //in milliseconds
	private Boolean timer_stopped;
	
	public Timer()
	{
		totalTime = 0;
		timer_stopped = true;
	}
	
	public void startTimer()
	{
		current_time = System.currentTimeMillis();
		timer_stopped = false;
	}
	
	public void stopTimer()
	{
		long i = System.currentTimeMillis();
		if(this.timer_stopped == false)
		{
			totalTime += i - current_time;
		}
		
		timer_stopped = true;
		
	}
	
	//returns in seconds of total timer the timer was running
	public long getTime() 
	{
		
		if(timer_stopped == false)
		{
			this.stopTimer();
			this.startTimer();
		}
		else
		{
			this.stopTimer();
		}
		
		//System.out.println("TotalTimeTaken"+ totalTime / 1000);
		return totalTime / 1000;
	}
	
}
