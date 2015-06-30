import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;


public class Trail {
	
	Square[] trail;
	
	boolean canMoveDown = true;
	boolean canMoveUp = true;
	boolean canMoveRight = true;
	boolean canMoveLeft = false;
	
	
	public Trail(int initialXPosition) {
		trail = new Square[3];
		trail[0] = new Square(initialXPosition, 20, Color.LIGHT_GRAY);
		trail[1] = new Square(initialXPosition + 20, 20, Color.GRAY);
		trail[2] = new Square(initialXPosition + 40, 20, Color.BLACK);
	}
	
	//render each square in trail
	public void paint(Graphics2D g) {
		for (Square currentSquare : trail){
			currentSquare.paint(g);
		}
	}
	
	public void moveRight(){
		if (canMoveRight){
			moveRestOfTrail();
			trail[2].x+=20;
		}
	}
	
	public void moveLeft(){
		if (canMoveLeft){
			moveRestOfTrail();
			trail[2].x-=20;
		}
	}
	
	public void moveUp(){
		if (canMoveUp){
			moveRestOfTrail();
			trail[2].y-=20;
		}
	}
	
	public void moveDown(){
		if (canMoveDown){
			moveRestOfTrail();
			trail[2].y+=20;
		}
	}
	
	public void moveRestOfTrail(){
		trail[0].x = trail[1].x;
		trail[0].y = trail[1].y;
		
		trail[1].x = trail[2].x;
		trail[1].y = trail[2].y;
	}
	

	
	public void move(int d) {
			switch(d) {
				case 1:
					moveLeft();
					break;
				case 2:
					moveUp();
					break;
				case 3:
					moveRight();
					break;
				case 4:
					moveDown();
					break;
			}
	}
	
	
	
	public int generateDirection(){
		
		int lower = 1;
		int upper = 5;
		int num, 
			newx = this.trail[0].getX(), 
			newy = this.trail[0].getY();
		do {
			 num = (int) (Math.random() * (upper - lower)) + lower;
			 switch(num){
			 	case 1: //left
			 		newx -= 20;
			 	case 2: //up
			 		newy -= 20;
			 	case 3: //right
			 		newx += 20;
			 	case 4: //down
			 		newy += 20;
			 }
			
		}while(newx == trail[1].getX() && newy == trail[1].getY());
		
		return num + 36;
	}
	

	
}
