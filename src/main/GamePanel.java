package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	final int originalTileSize = 16; //sprite size
	final int scale = 3;
	final int tileSize = originalTileSize * scale; //48
	
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;	
	
	final int screenWidth = tileSize * maxScreenCol; //768
	final int screenHeight = tileSize * maxScreenRow; //576
	KeyHandler keyH = new KeyHandler();
	
	Thread gameThread;
	
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	int FPS = 60;
	
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
		if(keyH.upPressed == true) {
			playerY -= playerSpeed;
		}
		if(keyH.downPressed == true) {
			playerY += playerSpeed;
		}
		if(keyH.leftPressed == true) {
			playerX -= playerSpeed;
		}
		if(keyH.rightPressed == true) {
			playerX += playerSpeed;
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		g2.dispose();		
	}
}
