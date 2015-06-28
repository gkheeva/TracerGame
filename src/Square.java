import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;


public class Square {
	int x = 60;
	int y = 40;
	int xa = 1;
	int ya = 1;
	private Game game;
	boolean canMoveRight = true; 
	boolean canMoveLeft = true; 
	boolean canMoveUp = true; 
	boolean canMoveDown = true; 
	
	private Trail trail;
	
	boolean moved = false;
	boolean movedRight = false;
	boolean movedLeft = false;
	boolean movedUp = false;
	boolean movedDown = false;
	
	public Square(Game game) {
		this.game = game;
		trail = game.trail;
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(x, y, 20, 20);
	}
	
	public void move() {
		
	}
	
	
	public void checkBounds(){
		if (x >= game.getWidth() - 20)
				canMoveRight = false;
		else canMoveRight = true;
		if	(x <= 0)
				canMoveLeft = false;
		else canMoveLeft = true;
		if	(y <= 0)
				canMoveUp = false;
		else canMoveUp = true;
		if	(y >= game.getHeight() - 20)
				canMoveDown = false;
		else canMoveDown = true;
	}
	
	public void stayOnTrail(){
		trail = game.trail;
		System.out.println(trail.x1);
		if (x + 20 != trail.x1)
			canMoveRight = false;
		else canMoveRight = true;
		
		if (x - 20 != trail.x1)
			canMoveLeft = false;
		else canMoveLeft = true;
		
		if (y + 20 != trail.y1)
			canMoveDown = false;
		else canMoveDown = true;
		
		if (y - 20 != trail.y1)
			canMoveUp = false;
		else canMoveUp = true;
		
	}
	
	public void keyPressed(KeyEvent e) {
		checkBounds();
		stayOnTrail();

			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				if (canMoveLeft) {
					moved = true;
					movedLeft = true;
					x-= 20;
				}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				if (canMoveRight) {
					moved = true;
					movedRight = true;
					x+= 20;
				}
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				if (canMoveDown) {
					moved = true;
					movedDown = true;
					y+= 20;
				}
			if (e.getKeyCode() == KeyEvent.VK_UP)
				if (canMoveUp) {
					moved = true;
					movedUp = true;
					y-= 20;
				}
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	
}
