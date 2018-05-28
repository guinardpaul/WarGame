package fr.guinard.wargame.world;

import java.awt.Graphics;

import fr.guinard.wargame.Handler;
import fr.guinard.wargame.tiles.Tile;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;

	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}

	private void loadWorld(String path) {
		width = 5;
		height = 5;
		tiles = new int[5][5];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = 0;
			}
		}
	}

	public void tick() {
	}

	public void render(Graphics g) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				getTile(x, y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
			}
		}
	}

	private Tile getTile(int x, int y) {
		Tile tile = Tile.tiles[tiles[x][y]];
		if (tile == null) {
			return Tile.grassTile;
		}
		return tile;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
