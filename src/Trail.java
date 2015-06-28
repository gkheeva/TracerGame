import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public class Trail {
	private Game game;
	int x1 = 80;
	int x2 = 100;
	int x3 = 120;
	
	int y1 = 40;
	int y2 = 40;
	int y3 = 40;
	
	boolean canMoveDown = true;
	boolean canMoveUp = true;
	boolean canMoveRight = true;
	boolean canMoveLeft = false;
	
	private Square square;
	
	public Trail(Game game) {
		this.game = game;
		square = game.square;
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x3, y3, 20, 20);
		g.setColor(Color.GRAY);
		g.fillRect(x2, y2, 20, 20);
		g.setColor(Color.BLACK);
		g.fillRect(x1, y1, 20, 20);	
	}
	
	public void moveRight(){
		if (canMoveRight){
			x1 = x2;
			y1 = y2;
				
			x2 = x3;
			y2 = y3;
			
			x3+=20;
		}
	}
	
	public void moveLeft(){
		if (canMoveLeft){
			x1 = x2;
			y1 = y2;
				
			x2 = x3;
			y2 = y3;
			
			x3-=20;
		}
	}
	
	public void moveUp(){
		if (canMoveUp){
			x1 = x2;
			y1 = y2;
			
			x2 = x3;
			y2 = y3;	
			
			y3-=20;
		}
	}
	
	public void moveDown(){
		if (canMoveDown){
			x1 = x2;
			y1 = y2;
			
			x2 = x3;
			y2 = y3;	
			
			y3+=20;
		}
	}
	
	private void updateCanMove(){
		if (x3 + 20 != x2)
			canMoveRight = true;
		else
			canMoveRight = false;
		
		if (x3 - 20 != x2)
			canMoveLeft = true;
		else
			canMoveLeft = false;
		
		if (y3 - 20 != y2)
			canMoveUp = true;
		else
			canMoveUp = false;
		
		if (y3 + 20 != y2)
			canMoveDown = true;
		else
			canMoveDown = false;
	}
	
	public void move() {
		if(square.moved){
			updateCanMove();
			keepTrailInBounds();
			moveRandom();
			resetSquareMoved();
		}
	}
	
	public void keepTrailInBounds(){
		if (x3 + 20 == game.getWidth())
			canMoveRight = false;
		if (x3 == 0)
			canMoveLeft = false;
		if (y3 + 20 >= game.getHeight())
			canMoveDown = false;
		if (y3 == 0)
			canMoveUp = false;
	}
	
	public void moveRandom(){
		int lower = 1;
		int upper = 5;
		int r = (int) (Math.random() * (upper - lower)) + lower;
		
		int x3old = x3;
		int y3old = y3;
		
		switch(r) {
		case 1: moveUp();
				break;
		case 2: moveDown();
				break;
		case 3: moveRight();
				break;
		case 4: moveLeft();
				break;
		}
		
		if (x3old == x3 && y3old == y3)
			moveRandom();
		
	}
	
	public void resetSquareMoved() {
		square.moved = false;
		square.movedRight = false;
		square.movedLeft = false;
		square.movedUp = false;
		square.movedDown = false;
	}
	
}
