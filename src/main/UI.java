package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;
import object.OBJ_KeyChest;

public class UI {

	GamePanel gp;
	Font arial_28, arial_80B;
	
	//ICONS
	BufferedImage keyImageChest;
	BufferedImage keyImageDoor;
	
	//MESSAGE SCREEN
	public String message = "";
	public boolean messageOn = false;
	int messageCounter = 0;
	public boolean gameFinished = false;
	
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_28 = new Font("Arial", Font.PLAIN, 38);
		arial_80B = new Font("Arial", Font.BOLD, 80);
		OBJ_Key key = new OBJ_Key();
		OBJ_KeyChest keyChest = new OBJ_KeyChest();
		keyImageDoor = key.image;
		keyImageChest = keyChest.image;
	}
	
	public void showMessage(String text) {
		
		
		
		message = text;
		messageOn = true;
	}
	public void draw(Graphics2D g2) {
		
		if(gameFinished == true) {
			
			g2.setFont(arial_28);
			g2.setColor(Color.white);
			
			String text;
			int textLength;
			int x;
			int y;
			
			text = "Level Cleared!";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 - (gp.tileSize*2);
			g2.drawString(text, x, y);
			
			text = "Yout time is : " + dFormat.format(playTime) + "!";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 - (gp.tileSize*4);
			g2.drawString(text, x, y);
			
			
			g2.setFont(arial_80B);
			g2.setColor(Color.yellow);
			text = "Congratulations!";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize*2);
			g2.drawString(text, x, y);
			
			gp.gameThread = null;
		}
		else {
			g2.setFont(arial_28);
			g2.setColor(Color.white);
			g2.drawImage(keyImageDoor,gp.tileSize/2, gp.tileSize/2 -10, gp.tileSize, gp.tileSize, null);
			g2.drawImage(keyImageChest,gp.tileSize/2 + 125 , gp.tileSize/2 - 10 , gp.tileSize, gp.tileSize, null);
			g2.drawString("x " + gp.player.hasKey, 75, 50);
			g2.drawString("x " + gp.player.hasChestKey, 200, 50);
			
			//TIME
			playTime += (double)1/60;
			g2.drawString("Time : " + dFormat.format(playTime), gp.tileSize*11, 65);
			
			//MESSAGE
			if(messageOn == true) {
				
				g2.setFont(g2.getFont().deriveFont(30F));
				g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
				
				messageCounter++;
				if(messageCounter > 120) {
					messageCounter = 0;
					messageOn = false;
				}
			}
			
		}
	}
}
