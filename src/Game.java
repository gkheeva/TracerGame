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
	InputHandler inputHandler;

	private int width, height;
	
	
	public Game(int width, int height) {
		player = new Square(180, 20, Color.RED);
		trail = new Trail(120);
		bar = new Sidebar();
		inputHandler = new InputHandler();
		this.width = width;
		this.height = height;
		
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
				if (!checkBounds(e.getKeyCode()))
					return;
				if (e.getKeyCode() == KeyEvent.VK_LEFT){
					player.moved = true;
					player.movedLeft = true;
					player.x -= 20;
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT){
					player.moved = true;
					player.movedRight = true;
					player.x+= 20;
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN){
					player.moved = true;
					player.movedDown = true;
					player.y+= 20;
				}
				if (e.getKeyCode() == KeyEvent.VK_UP){
					player.moved = true;
					player.movedUp = true;
					player.y-= 20;
				}
			}
		});
		setFocusable(true);
	}


	public void move() {
		player.move();
		int d;
		if(checkBounds(d = trail.generateDirection()))
		trail.move(d);
		if(player.moved){
			bar.raise();
			player.moved = false;
		}
		bar.move();

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
	/**
	 * 
	 * @param vector
	 * @return
	 */
	public boolean checkBounds(int vector){
		switch(vector){
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
	
	public void stayOnTrail(){
		player.canMoveRight = player.getX() + 20 == trail.trail[2].getX();
		player.canMoveLeft  = player.getX() - 20 == trail.trail[2].getX();
		player.canMoveUp = player.getY() + 20 == trail.trail[2].getY();
		player.canMoveDown = player.getY() - 20 == trail.trail[2].getY();
		
	}
}
