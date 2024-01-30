package main;
import javax.swing.JFrame;
public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes sure there's an x icon
		window.setResizable(false); //doesn't allow resizing the window
		window.setTitle("2D Adventure"); // title
		
		GamePanel gamePanel = new GamePanel(); //add after creating GamePane class
		window.add(gamePanel);
		window.pack(); //resizes and layouts all elements inside window
		
		window.setLocationRelativeTo(null); // just appears in the middle
		window.setVisible(true); //window will be visible to you
		
		gamePanel.startGameThread();
	}

}
