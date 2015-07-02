import java.util.Timer;
import java.util.TimerTask;


public class LowerBarTask extends TimerTask{
	Timer timer;
	long period;
	public boolean shouldLower;
	
	public LowerBarTask(){
		timer = new Timer();
		period = 5000;
		shouldLower = false;
		timer.scheduleAtFixedRate(this, 500, period);
	}
	
	
	@Override
	public void run() {
		shouldLower = true;
	}
}
