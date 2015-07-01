import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Vector;


public class Square {
	int x;
	int y;
	Color color;
	int width = 20;
	int height = 20;
	
	boolean canMoveRight = true; 
	boolean canMoveLeft = true; 
	boolean canMoveUp = true; 
	boolean canMoveDown = true; 
	
	
	boolean moved = false;
	boolean movedRight = false;
	boolean movedLeft = false;
	boolean movedUp = false;
	boolean movedDown = false;
	
	public Square(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void paint(Graphics2D g) {
		g.setColor(this.color);
		g.fillRect(x, y, 20, 20);
	}
	
	public void move(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			x -= 20;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			x+= 20;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			y+= 20;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			y-= 20;
		}
	}
	
	public int getX(){return x;}
	public int getY(){return y;}
}
