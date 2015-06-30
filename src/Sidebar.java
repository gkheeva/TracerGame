import java.awt.Color;
import java.awt.Graphics2D;


public class Sidebar {
	
	int maxHeight = 10;
	int minHeight = 0;
	int height = 5;
	
	
	public Sidebar(){
	}
	
	public void move(){
		raise();
		raise();
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, 20, 250);
		g.setColor(Color.white);
		g.fillRect(0, 0, 20, 250 - (20*height));
		
	}
	
	
	public void lower() {
		if (height > minHeight)
			height--;
	}
	
	public void raise() {
		if (height < maxHeight)
			height++;
	}
	
}
