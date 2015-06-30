import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class InputHandler extends JPanel {
	
	boolean keyReleased = true;
	boolean keyPressed = false;
	
	public InputHandler() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
	
			@Override
			public void keyReleased(KeyEvent e) {
				keyReleased = true;
				keyPressed = false;
			}
	
			@Override
			public void keyPressed(KeyEvent e) {
				keyReleased = false;
				keyPressed = true;
			}
		});
		setFocusable(true);
	}

}
