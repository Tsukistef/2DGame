package main;

import object.OBJ_Chest;
import object.OBJ_Key;
import object.OBJ_KeyChest;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void SetObject() {
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 8 * gp.tileSize;
		gp.obj[0].worldY = 28 * gp.tileSize;
		
		gp.obj[1] = new OBJ_KeyChest();
		gp.obj[1].worldX = 41 * gp.tileSize;
		gp.obj[1].worldY = 3 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Chest();
		gp.obj[2].worldX = 14 * gp.tileSize;
		gp.obj[2].worldY = 2 * gp.tileSize;
	}
}
