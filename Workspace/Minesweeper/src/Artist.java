
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  

public class Artist {

	//TODO add timer display
	private JToggleButton  array[][];
	private JFrame f;
	
	
	public Artist(Board toDraw){
		//draw the Board up right away
		
		draw(toDraw);
		
	}
	
	public void redraw(Board toDraw)
	{
		f.dispose();
		draw(toDraw);
		return;
	}
	
	private void draw(Board toDraw)
	{
		int size = toDraw.getsize();
		
		//create all of the gird buttons
		f=new JFrame();//creating instance of JFrame  
		array = new JToggleButton  [size][size];
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				
				JToggleButton  b=new JToggleButton (Integer.toString(i) + "," + Integer.toString(j));//creating instance of JButton  
				b.setBounds((i * 15 ) + 30,(j * 15 ) + 180, 10, 10);//x axis, y axis, width, height  
				Dimension d = new Dimension(10, 10);
				b.setSize(d);
				b.addActionListener(actionListener);
				f.add(b);//adding button in JFrame  
				array[i][j] = b;
			}			
		}

		
		//highscore
		JButton highscoreButton =new JButton("High Scores");//creating instance of JButton  
		highscoreButton.setBounds(140,10,120, 60);//x axis, y axis, width, height  
		highscoreButton.addActionListener(actionListener);
		f.add(highscoreButton);//adding button in JFrame  
		
		//restart
		JButton restartButton =new JButton("Restart");//creating instance of JButton  
		restartButton.setBounds(10,10,100, 60);//x axis, y axis, width, height  
		restartButton.addActionListener(actionListener);
		f.add(restartButton);//adding button in JFrame  
		
		//stop timer
		JButton stopTimerButton =new JButton("Stop Timer");//creating instance of JButton  
		stopTimerButton.setBounds(280,10,120, 60);//x axis, y axis, width, height  
		stopTimerButton.addActionListener(actionListener);
		f.add(stopTimerButton);//adding button in JFrame  	
		
		//timer display
		//TODO
		JButton showTimerButton =new JButton("Show Timer");//creating instance of JButton  
		showTimerButton.setBounds(140,90,120, 60);//x axis, y axis, width, height  
		showTimerButton.addActionListener(actionListener);
		f.add(showTimerButton);//adding button in JFrame  	
		
		//change difficulty
		JButton ChangeDifButton =new JButton("Change Diffculty");//creating instance of JButton  
		ChangeDifButton.setBounds(10,90,120, 60);//x axis, y axis, width, height  
		ChangeDifButton.addActionListener(actionListener);
		f.add(ChangeDifButton);//adding button in JFrame  
		
		
		//create the GUI it self
		f.setSize(( (size * 20) + 150),( (size * 20) + 150) );//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
	}
	
	//used to determine when a button is pressed
	//TODO???? -- figure out a way to move this class to the manager instead -- don't actual have to do this
	ActionListener actionListener = new ActionListener() 
	{
	    public void actionPerformed(ActionEvent actionEvent) {
	       
	    	
	        String command = actionEvent.getActionCommand();
	        System.out.println("command at: "+ command );
	        //figure out the command and act on it
	        // gird buttons have a comma in them
	        if(command.contains(","))
	        {
		        String[] coords = command.split(",");
		        Manager.buttonPress(Integer.valueOf(coords[0]), Integer.valueOf(coords[1]));
	        }
	        else if(command.contains("Restart"))
	        {
	        	Manager.restart();
	        }
	        else if(command.contains("High Scores"))
	        {
	        	this.displayHighScores();
	        }
	        else if(command.contains("Stop Timer"))
	        {
	        	Manager.StopTimer();
	        }
	        else if(command.contains("Change Diffculty"))
	        {
	        	this.changeDiffculty();
	        }
	        else if(command.contains("Show Timer"))
	        {
	        	Timer time = new Timer();
	        	time.getTime();	        	
	        	
	        }
	    }

		private void changeDiffculty() {
			 String difS = JOptionPane.showInputDialog(f,"Change Diffculty, Enter 1 for Easy, 2 for Normal (default) and 3 for hard");
			 int dif;
			 try {
				  dif = Integer.valueOf(difS);
			 }
			 catch (Exception e)
			 {
				  dif = 2;
			 }
			 
			 if (dif == 1)
			 {
				 Manager.setDifficulty(diffculty.Easy);
			 }
			 else if(dif == 3)
			 {
				 Manager.setDifficulty(diffculty.Hard);
			 }
			 else
			 {
				 Manager.setDifficulty(diffculty.Meduim);
			 }
			
		}

		private void displayHighScores() {
			//TODO actually display highscores
			HighScoreManager highScore = new HighScoreManager();
			highScore.getHighScores();
			
		}
	};
	
	void drawLose()
	{
		JOptionPane.showMessageDialog(f,"You Lost, would like to try again?");
	}

	void drawWin(long l)
	{
		JOptionPane.showMessageDialog(f,"Congrats you won!, With a Time of: " + Long.toString(l));
	}
	
	void updateLocationNumber(int x, int y, int mines)
	{
		System.out.println("updating at: " + Integer.toString(x) + "," + Integer.toString(y) );
		array[x][y].removeAll();
		f.remove(array[x][y]);
		
		array[x][y] = null;
		//TODO add icons of correct size and then using mines set the correct of the image of the button
		// mines is the number needing to be displayed and should be drawn
		ImageIcon icon1 = createImageIcon("icon 1.png", "1");
		JToggleButton  b = new JToggleButton (Integer.toString(x) + "," + Integer.toString(y),icon1 );//creating instance of JButton  
		//redraw button in the correct place
		b.setBounds((x * 15 ) + 30,(y * 15 ) + 180, 10, 10);//x axis, y axis, width, height  
		b.addActionListener(actionListener);
		f.add(b);//adding button in JFrame  
		array[x][y] = b;
		return;
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path,
	                                           String description) {
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
	
	
	
}
