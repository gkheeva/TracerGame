import javax.swing.JFrame;


public class GameController{
	public static Game game;
	private static int height = 140, width = 140;
	public static JFrame frame;

	
	public GameController(){
			//TODO
	}
	public static void main(String[] args) throws InterruptedException {
		
		game = new Game(width, height);
		frame = new JFrame("Tracer");
		
		frame.add(game);
		
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(5);
		}
		
	}
}
