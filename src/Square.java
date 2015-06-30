import java.awt.Color;
import java.awt.Graphics2D;


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
	
	public void move() {
		
	}
	
	public int getX(){return x;}
	public int getY(){return y;}
}
