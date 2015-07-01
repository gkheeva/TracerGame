import java.awt.Color;
import java.awt.Graphics2D;


public class Sidebar {
	
	int maxHeight;
	int minHeight = 0;
	int height;
	
	
	public Sidebar(int height){
		maxHeight = height;
		this.height = maxHeight / 2 + 20;
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
		if (height > minHeight)
			height-=5;
	}
	
	public void raise() {
		if (height < maxHeight)
			height+=5;
	}
	
}
