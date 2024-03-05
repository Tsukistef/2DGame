package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Chest extends SuperObject{

	GamePanel gp;
	
	public OBJ_Chest() {
		name = "Chest";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/tile_chest.png"));
		} 
		catch(IOException e) {
				e.printStackTrace();
		}
		collision = true;
	}
}
