package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {

	GamePanel gp;
	Tile[] tile;
	int mapTileNum[][];
	
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp; //instantiate itself, GamePanel
		tile = new Tile[10]; //instantiates the array
		mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
		getTileImage(); //contains images for tiles, determining array
		LoadMap();
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
		public void LoadMap(){
			try {
				InputStream is = getClass().getResourceAsStream("/maps/map_1.txt"); //retrieves text file
				BufferedReader br = new BufferedReader(new InputStreamReader(is)); //reads inside file
				int col = 0;
				int row = 0;
				while(col < gp.maxScreenCol && row < gp.maxScreenCol) {
					String line = br.readLine(); //only reads string line
				
				while(col < gp.maxScreenCol) {
					String numbers[] = line.split(" "); //separates numbers with space
					int num = Integer.parseInt(numbers[col]); //converts the string to integer
					mapTileNum[col][row] = num;
					col++;
					}
				if(col == gp.maxScreenCol) {
					col = 0;
					row++;
				}
				}
				br.close();
		}
		catch(Exception e) {
		}
		}
		
		public void draw(Graphics2D g2) { //draws the tiles, like we did with Player images
			
			int col = 0;
			int row = 0;
			int x = 0;
			int y = 0;
			
			while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
				int tileNum = mapTileNum[col][row];
				
				g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
				col++;
				x += gp.tileSize;
			
			if(col == gp.maxScreenCol) {
				col = 0;
				x = 0;
				row++;
				y += gp.tileSize;
			}
		}
		}
}
