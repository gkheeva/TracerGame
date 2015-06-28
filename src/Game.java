import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JPanel {
	
	
	Square square = new Square(this);
	Trail trail = new Trail(this);
	
	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				square.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				square.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	private void move() {
		square.move();
		trail.move();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(Color.BLACK);
		trail.paint(g2d);
		g2d.setColor(Color.RED);
		square.paint(g2d);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Tracer");
		Game game = new Game();
		frame.add(game);
		frame.setSize(200, 160);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(3);
		}
		
	}
	
	
	
	

}
