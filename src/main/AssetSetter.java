package main;

import object.OBJ_Key;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void SetObject() {
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 14 * gp.tileSize;
		gp.obj[0].worldY = 2 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldX = 8 * gp.tileSize;
		gp.obj[1].worldY = 28 * gp.tileSize;
	}
}
