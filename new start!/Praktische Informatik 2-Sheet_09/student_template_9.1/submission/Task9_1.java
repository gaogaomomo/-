package submission;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Task9_1 extends JFrame {
	
	private Task9_1()
	{
		setTitle("Snake");
		setSize(1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Task9_1 window = new Task9_1();
		
		SnakeGame snakeGame = new SnakeGame();
		
		window.add(snakeGame);
		window.addKeyListener(snakeGame);
		
		window.setVisible(true);
		
		final int gameLogicInterval = 9;
		
		// set a timer for 16 milliseconds for a 60 Hz refresh
		Timer mainLoopTimer = new Timer(16, new ActionListener() {
			int counter = 0;
			
			public void actionPerformed(ActionEvent evt) {
				++counter;
				if (counter == gameLogicInterval) {
					counter = 0;
					snakeGame.nextStep();
				}
				window.repaint();
			}
		});
		
		mainLoopTimer.start();
		
		// java is weird: we exit the main function here, but the program keeps running
	}
};
