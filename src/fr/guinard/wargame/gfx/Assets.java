package fr.guinard.wargame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private final static int WIDTH = 32;
	private final static int HEIGHT = 32;
	private final static int FOREST_WIDTH = 31;
	private final static int FOREST_HEIGHT = 31;
	private final static int PLAYER_WIDTH = 32;
	private final static int PLAYER_HEIGHT = 48;
	// Static assets
	public static BufferedImage grass;
	public static BufferedImage cut_tree;
	public static BufferedImage[] player_down, player_up, player_right, player_left;

	public static void init() {
		SpriteSheet tilesSheet = new SpriteSheet(ImageLoader.loadImage("/map/tiles_sheet.png"));
		SpriteSheet forestSheet = new SpriteSheet(ImageLoader.loadImage("/map/tiles_forest_sheet.png"));
		SpriteSheet charSheet = new SpriteSheet(ImageLoader.loadImage("/characters/player.png"));
		
		// Map
		grass = tilesSheet.crop(WIDTH * 4, HEIGHT * 6, WIDTH, HEIGHT);
		cut_tree = forestSheet.crop(FOREST_WIDTH * 4, FOREST_HEIGHT, FOREST_WIDTH, FOREST_HEIGHT);
		
		// Player
		player_down=new BufferedImage[4];
		player_down[0] = charSheet.crop(0, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_down[1] = charSheet.crop(PLAYER_WIDTH, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_down[2] = charSheet.crop(PLAYER_WIDTH * 2, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_down[3] = charSheet.crop(PLAYER_WIDTH * 3, 0, PLAYER_WIDTH, PLAYER_HEIGHT);

		player_up = new BufferedImage[4];
		player_up[0] = charSheet.crop(0, PLAYER_HEIGHT * 3, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_up[1] = charSheet.crop(PLAYER_WIDTH, PLAYER_HEIGHT * 3, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_up[2] = charSheet.crop(PLAYER_WIDTH * 2, PLAYER_HEIGHT * 3, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_up[3] = charSheet.crop(PLAYER_WIDTH * 3, PLAYER_HEIGHT * 3, PLAYER_WIDTH, PLAYER_HEIGHT);

		player_left = new BufferedImage[4];
		player_left[0] = charSheet.crop(0, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_left[1] = charSheet.crop(PLAYER_WIDTH, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_left[2] = charSheet.crop(PLAYER_WIDTH * 2, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_left[3] = charSheet.crop(PLAYER_WIDTH * 3, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);

		player_right = new BufferedImage[4];
		player_right[0] = charSheet.crop(0, PLAYER_HEIGHT * 2, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_right[1] = charSheet.crop(PLAYER_WIDTH, PLAYER_HEIGHT * 2, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_right[2] = charSheet.crop(PLAYER_WIDTH * 2, PLAYER_HEIGHT * 2, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_right[3] = charSheet.crop(PLAYER_WIDTH * 3, PLAYER_HEIGHT * 2, PLAYER_WIDTH, PLAYER_HEIGHT);
	}

}
