import java.awt.Color;


public class Player extends Square {
	
	boolean moved;
	
	public Player(int x, int y, Color color) {
		super(x, y, Color.decode("#FF4D00"));
		moved = false;
	}

	public void move(){
		moved = true;
	}
	

}
