package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 5876538040638144578L;
	
	//SCREEN SETTINGS
	final int originalTileSize = 16; //sprite size
	final int scale = 3;
	public final int tileSize = originalTileSize * scale; //48
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;	
	public final int screenWidth = tileSize * maxScreenCol; //768
	public final int screenHeight = tileSize * maxScreenRow; //576
	
	//WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int WorldWidth = tileSize * maxWorldCol; // actual world map size, NOT screen
	public final int WorldHeight = tileSize * maxWorldRow;
	
	//FPS
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public Player player = new Player(this, keyH);
	
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	
	//Create new constructor for GamePanel
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() { //constructor
		gameThread = new Thread(this); //instantiate Thread
		gameThread.start();
	}
	
	public void run() {
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread != null) {
			
			//System.out.println("The game is running");
			//Update and draw
			update();
			repaint();
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;
				}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void update() {
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		Graphics2D g2 = (Graphics2D)g;
		tileM.draw(g2);
		player.draw(g2);
		
		g2.dispose();		
	}
}
