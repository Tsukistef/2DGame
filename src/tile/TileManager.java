package tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {

	GamePanel gp;
	Tile[] tile;
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp; //instantiate itself, GamePanel
		tile = new Tile[10]; //instantiates the array
		getTileImage(); //contains images for tiles, determining array
	}
		
		public void getTileImage() {
			try {
				tile[0] = new Tile();
				tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_grass.png"));
				
				tile[1] = new Tile();
				tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_brick.png"));
				
				tile[2] = new Tile();
				tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_water.png"));
			} catch(IOException e) {
				e.printStackTrace();
			}
	      }
		public void draw(Graphics2D g2) { //draws the tiles, like we did with Player images
			g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
		}
}
