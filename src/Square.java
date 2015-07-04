import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public class Square {
	int x;
	int y;
	Color color;
	int width = 20;
	int height = 20;
	public boolean moved;
	
	
	public Square(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		moved = false;
		this.color = color;
	}
	
	public void paint(Graphics2D g) {
		g.setColor(this.color);
		g.fillRect(x, y, 20, 20);
	}
	
	public void move(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			x -= 20;
			moved = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			x+= 20;
			moved = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			y+= 20;
			moved = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			y-= 20;
			moved = true;
		}
	}
	
	public int getX(){return x;}
	public int getY(){return y;}
}
