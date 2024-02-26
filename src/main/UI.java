package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_Key;
import object.OBJ_KeyChest;

public class UI {

	GamePanel gp;
	Font arial_28;
	
	//IONS
	BufferedImage keyImageChest;
	BufferedImage keyImageDoor;
	
	//MESSAGE SCREEN
	public String message = "";
	public boolean messageOn = false;
	int messageCounter = 0;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_28 = new Font("Arial", Font.PLAIN, 38);
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
		
		g2.setFont(arial_28);
		g2.setColor(Color.white);
		g2.drawImage(keyImageDoor,gp.tileSize/2, gp.tileSize/2 -10, gp.tileSize, gp.tileSize, null);
		g2.drawImage(keyImageChest,gp.tileSize/2 + 125 , gp.tileSize/2 - 10 , gp.tileSize, gp.tileSize, null);
		g2.drawString("x " + gp.player.hasKey, 75, 50);
		g2.drawString("x " + gp.player.hasChestKey, 200, 50);
		
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
