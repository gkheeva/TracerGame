import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;


public class Sidebar {
	
	int maxHeight;
	int minHeight = 0;
	int height;
	long barDropRate;
	Timer timer;
	
	public Sidebar(int height){
		maxHeight = height;
		this.height = maxHeight / 2 + 20;
		this.barDropRate = 290;
		timer = new Timer();
		
		timer.schedule(new LevelUpTask(), 0, 4000);
	}
	
	
	class LevelUpTask extends TimerTask{

		@Override
		public void run() {
			barDropRate = (long) Math.ceil(barDropRate / 1.5);
			timer.scheduleAtFixedRate(new LowerBarTask(), 500, barDropRate);
		}
		
	}
	class LowerBarTask extends TimerTask{

		@Override
		public void run() {
			lower();
		}
	}
	
	public void levelUp(){
		this.barDropRate = (long) Math.ceil(this.barDropRate/1.05);
	}
	
	public void move(){

	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, 20, maxHeight);
		g.setColor(Color.white);
		g.fillRect(0, 0, 20, maxHeight - height);
	}
	
	public void lower() {
		System.out.println("BAR LOWER");
		if (height > minHeight)
			height-=1;
	}
	
	public void raise() {
		if (height < maxHeight)
			height+=5;
	}
	
}
