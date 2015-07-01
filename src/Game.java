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
	
	public boolean moveOnTrail(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP: //up
			if(player.getY() - 20 == trail.trail[2].getY()){
				player.move(e);
			return true;
			}
		case KeyEvent.VK_DOWN: //down
			if(player.getY() + 20 == trail.trail[2].getY()){
				player.move(e);
			return true;
			}
		case KeyEvent.VK_LEFT: //left
			if(player.getX() - 20 == trail.trail[2].getX()){
				player.move(e);
			return true;
			}
		case KeyEvent.VK_RIGHT: //right
			if(player.getX() + 20 == trail.trail[2].getX()){
				player.move(e);
			return true;
			}
		default: return false;
		}
	}
}
