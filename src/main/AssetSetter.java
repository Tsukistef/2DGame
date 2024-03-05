package main;

import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_KeyChest;
import object.OBJ_SlowMush;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void SetObject() {
		
		//BLUE KEY OPENS DOORS, PINK KEY CHEST
		gp.obj[0] = new OBJ_Key(); //RUINS DOOR KEY (IN TOP TREES)
		gp.obj[0].worldX = 8 * gp.tileSize;
		gp.obj[0].worldY = 28 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key(); //LAKE DOOR (IN MIDDLE LAKE)
		gp.obj[1].worldX = 1 * gp.tileSize; 
		gp.obj[1].worldY = 19 * gp.tileSize;
		
		gp.obj[2] = new OBJ_KeyChest(); //RUINS CHEST KEY
		gp.obj[2].worldX = 41 * gp.tileSize;
		gp.obj[2].worldY = 3 * gp.tileSize;
		
		gp.obj[3] = new OBJ_KeyChest(); //KEYS BOTTOM CHEST
		gp.obj[3].worldX = 39 * gp.tileSize;
		gp.obj[3].worldY = 15 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Chest(); // RUINS CHEST
		gp.obj[4].worldX = 14 * gp.tileSize;
		gp.obj[4].worldY = 2 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Chest(); //BOTTOM LAKE CHEST
		gp.obj[5].worldX = 31 * gp.tileSize;
		gp.obj[5].worldY = 45 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Door(); //RUINS DOOR
		gp.obj[6].worldX = 9 * gp.tileSize;
		gp.obj[6].worldY = 7 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Door(); //MIDLAKE DOOR
		gp.obj[7].worldX = 36 * gp.tileSize;
		gp.obj[7].worldY = 26 * gp.tileSize;
		
		gp.obj[8] = new OBJ_Boots();
		gp.obj[8].worldX = 40 * gp.tileSize;
		gp.obj[8].worldY = 42 * gp.tileSize;
		
		gp.obj[9] = new OBJ_SlowMush();
		gp.obj[9].worldX = 20 * gp.tileSize;
		gp.obj[9].worldY = 47 * gp.tileSize;
	
	}
}
