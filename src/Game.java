import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;

import javax.swing.JPanel;


public class Game extends JPanel {
	
	
	Square player;
	Trail trail;
	Sidebar bar; 
	Graphics2D g2d;
	boolean gameOver;
	private int width, height;
	FontMetrics fontMetrics;
	
	public Game(int width, int height) {
		System.out.println("Start Game..");
		this.gameOver = false;
		this.width = width;
		this.height = height;
		player = new Player(120, 200, Color.RED);
		trail = new Trail(player.getX() - 60, player.getY(), this.width, this.height);
		bar = new Sidebar(height);
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (moveOnTrail(e)){
					int d;
					d = trail.generateDirection();
					trail.move(d);
				}
			}
		});
		setFocusable(true);
	}
	

	public void move() {
		if(!gameOver){
			if(player.moved){
				bar.raise();
			player.moved = false;
			}
			bar.move();
			gameOver();
		}
	}
	
	public void gameOver(){
		if (bar.height <= 0){
			gameOver = true;
			System.out.println("Game Over!!!!!!!!!!!!!!!!!");
			//TODO!!!!!!!!!!!
		}
	}

	

	@Override
	public void paint(Graphics g) {
		if(!gameOver){
			super.paint(g);
			this.g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
					RenderingHints.VALUE_ANTIALIAS_ON);
	
			trail.paint(g2d);
			player.paint(g2d);
			bar.paint(g2d);
			
			
			if(bar.leveledUp){
				g2d.setFont(new Font("Monospaced", Font.BOLD, 50));
				g2d.setColor(Color.ORANGE);
				g2d.drawString("Level", width/2 - 75, height/3);
				g2d.setFont(new Font("Monospaced", Font.BOLD, 140));
				g2d.drawString("" + bar.level, width/2 - 40, height/2 + 70);
				bar.timer.schedule(new getRidOf(), 200);
			}
			
		}
		else{
			Font font = new Font("Monospaced", Font.BOLD, 35);
			fontMetrics = g.getFontMetrics(font);
			String message = "Game Over";
			int titleWidth = fontMetrics.stringWidth(message);
			super.paint(g);
			g.clearRect(0, 0, width, height);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.BLACK);
			g.drawString(message, width/2 - titleWidth / 2, height/2 - 10);
			
			message = "Reached: Level " + bar.level;
			fontMetrics = g.getFontMetrics(font = new Font("Monospaced", Font.BOLD, 15));
			g.setFont(font);
			titleWidth = fontMetrics.stringWidth(message);
			g.setColor(Color.RED);
			g.drawString(message, width/2 - titleWidth / 2, height/2 + 10);
			}
	}

	
	class getRidOf extends TimerTask {

		@Override
		public void run() {
			bar.leveledUp = false;
		}
		
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
