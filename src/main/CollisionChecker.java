package main;

import entity.Entity;

public class CollisionChecker{
	GamePanel gp;
		
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}	
	public void checkTile(Entity entity) {
		
		//IT DEFINES THE RECTANGLE EDGES
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		//IT DEVIDES THE PIXELS TO FIND OUT NUMBER OF TILES THAT MAKE UP DISTANCE
		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		/* THE 2 TILES CORNERS THAT THE PLAYER WILL TOUCH AS IT MOVES, WE FIND OUT WITH A SWITCH STATEMENT WHICH ONES THEY WILL BE DEPENDING ON
		DIRECTION */
		int tileNum1, tileNum2; 
		
		switch(entity.direction) {
			case "up":
				entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
				
				if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
					entity.collisionOn = true;
					entity.worldY += 0;
				}					
				break;
				
			case "down":
				entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
				
				if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
					entity.collisionOn = true;
					entity.worldY -= 0;
				}
				break;
					
			case "left":
				entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
				
				if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
					entity.collisionOn = true;
					entity.worldX += 0;
				}
				break;
			case "right":
				entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
				
				if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
					entity.collisionOn = true;
					entity.worldX -= 0;
				}
				break;
			}
	}
	
	public int checkObject(Entity entity, boolean player) {
		int index = 999;
		for(int i = 0; i < gp.obj.length; i++) { //iterates through the obj[] array
			if(gp.obj[i] != null) { // if there is an element in the array (if it is not null)
			//Get entity solid area position
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
			// Get object solid area position
				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
				
				switch(entity.direction) {
				case "up":
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
							entity.worldY += 20;
						}
						if(player == true) {
						index = i;	
						}
					}
				break;
				
				case "down":
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
							entity.worldY -= 20;
						}
						if(player == true) {
						index = i;	
						}
					}
				break;
					
				case "right":
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
							entity.worldX -= 20;
						}
						if(player == true) {
						index = i;	
						}
					}
					break;
					
				case "left":
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
							entity.worldX += 20;
						}
						if(player == true) {
						index = i;	
						}
					}
				break;
				}
			entity.solidArea.x = entity.solidAreaDefaultX;
			entity.solidArea.y = entity.solidAreaDefaultY;
			gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
			gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
			}
		}
		return index;
	}
}
