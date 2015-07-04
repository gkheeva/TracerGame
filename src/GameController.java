import java.awt.Dimension;

import javax.swing.JFrame;


public class GameController{
	public static Game game;
	private static int height = 260, width = 260;
	public static JFrame frame;

	
	public GameController() {
			//TODO
	}
	public static void main(String[] args) {
		
		game = new Game(width, height);
		frame = new JFrame("Tracer");
		game.setPreferredSize(new Dimension(width, height));
		frame.add(game);
		frame.pack();
	
		//frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		while (true) {
			game.move();
			game.repaint();
			}
	}
	
}
