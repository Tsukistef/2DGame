package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_KeyChest extends SuperObject {
	
	public OBJ_KeyChest() {
		name = "Key Chest";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/tile_key2.png"));
		} catch(IOException e) {
				e.printStackTrace();
		}
	}
}
