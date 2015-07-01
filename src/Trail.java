import java.awt.Color;
import java.awt.Graphics2D;


public class Trail {

	Square[] trail;
	boolean canMoveRight = true;
	boolean canMoveLeft = true;
	boolean canMoveUp = true;
	boolean canMoveDown = true;
	
	private int width, height;

	public Trail(int initialXPosition, int width, int height) {
		trail = new Square[3];
		trail[0] = new Square(initialXPosition, 20, Color.LIGHT_GRAY);
		trail[1] = new Square(initialXPosition + 20, 20, Color.GRAY);
		trail[2] = new Square(initialXPosition + 40, 20, Color.BLACK);
		this.width = width;
		this.height = height;
	}

	//render each square in trail
	public void paint(Graphics2D g) {
		for (Square currentSquare : trail){
			currentSquare.paint(g);
		}
	}

	public void moveRight(){
		
			moveRestOfTrail();
			trail[0].x += 20;
		
	}

	public void moveLeft(){
	
			moveRestOfTrail();
			trail[0].x -= 20;
		
	}

	public void moveUp(){
		
			moveRestOfTrail();
			trail[0].y-=20;
		
	}

	public void moveDown(){
		
			moveRestOfTrail();
			trail[0].y+=20;
		
	}

	public void moveRestOfTrail(){
		trail[2].x = trail[1].x;
		trail[2].y = trail[1].y;

		trail[1].x = trail[0].x;
		trail[1].y = trail[0].y;
	}



	public void move(int d) {
		d -= 36;
		System.out.print(d);
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



	public int randomNumber(){
		int lower = 1;
		int upper = 5;
		int r = (int) (Math.random() * (upper - lower)) + lower;
		return r;
	}
	


	
	public int generateDirection(){
		int newX, newY, r;
		do{
			r = randomNumber();
			
			newX = trail[0].getX();
			newY = trail[0].getY();
			
			switch(r) { 
			case 1: newX-=20;
					break;
			case 2: newY-=20;
					break;
			case 3: newX+=20;
					break;
			case 4: newY+=20;
					break;
		}
		}
		while((newX == trail[1].getX() && newY == trail[1].getY()) ||
				newX < 0 || newY < 0 || (newX + 20) >= width || (newY + 20) >= height);
		
		return r + 36;
		}
	
}
