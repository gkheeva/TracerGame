import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class Game extends JPanel {
	
	
	Square player;
	Trail trail;
	Sidebar bar; 

	private int width, height;
	
	
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		player = new Square(80, 20, Color.RED);
		trail = new Trail(player.getX() - 60, this.width, this.height);
		bar = new Sidebar();
		
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				///
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("skdjfal");
				if (!checkBounds(e.getKeyCode())){
					System.out.println("OUT OF BOUNDS TRIED");
					return;
				}
				keepTrailInBounds();
				if (moveOnTrail(e)){
					int d;
					d = trail.generateDirection();
					System.out.println(d);
					trail.move(d);
				}
				
			}
		});
		setFocusable(true);
	}
	

	public void move() {
		
		//if(player.moved){
		//	bar.raise();
		//	player.moved = false;
		//}
		//bar.move();

	}

	

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		//g2d.setBackground(Color.white);      nOT WORKING
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);

		trail.paint(g2d);
		player.paint(g2d);
		//bar.paint(g2d);

	}

	
	public void keepTrailInBounds(){
		if (trail.trail[0].getX() + 20 > width)
			trail.canMoveRight = false;
		else trail.canMoveRight = true;
		
		if (trail.trail[0].getX() - 20 < 0)
			trail.canMoveLeft = false;
		else trail.canMoveLeft = true;
		
		if (trail.trail[0].getY() + 20 > height)
			trail.canMoveDown = false;
		else trail.canMoveDown = true;
		
		if (trail.trail[0].getY() + 20 < 0)
			trail.canMoveUp = false;
		else trail.canMoveUp = true;
	}

	public boolean checkBounds(int d){
		switch(d){
		case KeyEvent.VK_UP: //up
			if(player.getY() - 20 < 0)
				return false;
			break;
		case KeyEvent.VK_DOWN: //down
			if(player.getY() + 20 > this.height)
				return false;
			break;
		case KeyEvent.VK_LEFT: //left
			if(player.getX() - 20 < 0 )
				return false;
			break;
		case KeyEvent.VK_RIGHT: //right
			if(player.getX() + 20 > this.width)
				return false;
			break;
		default: //none of the above keys
			return false;
		}
		return true;
	}
	
	public boolean moveOnTrail(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP: //up
			if(player.getY() - 20 == trail.trail[2].getY()){
				player.move(e);
			return true;
			}
			break;
		case KeyEvent.VK_DOWN: //down
			if((player.getY() + 20) == trail.trail[2].getY()){
				player.move(e);
			return true;
			}
			break;
		case KeyEvent.VK_LEFT: //left
			if(player.getX() - 20 == trail.trail[2].getX()){
				player.move(e);
			return true;
			}
			break;
		case KeyEvent.VK_RIGHT: //right
			if(player.getX() + 20 == trail.trail[2].getX()){
				player.move(e);
			return true;
			}
			break;
		}
		return false;
	}
}
