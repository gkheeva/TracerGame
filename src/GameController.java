import javax.swing.JFrame;


public class GameController{
	public static Game game;
	private static int height = 240, width = 240;
	public static JFrame frame;

	
	public GameController(){
			//TODO
	}
	public static void main(String[] args) {
		
		game = new Game(width, height);
		frame = new JFrame("Tracer");
		
		//LowerBarTask lowerBarTask = new LowerBarTask();
		
		frame.add(game);
		
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		while (true) {
			game.move();
			game.repaint();
			
			}
		}
		
	
}
