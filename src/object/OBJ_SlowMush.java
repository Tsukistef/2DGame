package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_SlowMush extends SuperObject {
	
	public OBJ_SlowMush() {
		name = "Slow Mushroom";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/slowmush.png"));
		} catch(IOException e) {
				e.printStackTrace();
		}
	}
}
