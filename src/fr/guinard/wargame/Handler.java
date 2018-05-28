package fr.guinard.wargame;

import fr.guinard.wargame.input.KeyManager;
import fr.guinard.wargame.world.World;

public class Handler {

	private Game game;
	private World world;

	public Handler(Game game) {
		this.game = game;
	}

	public int getWidth() {
		return game.getWIDTH();
	}

	public int getHeight() {
		return game.getHEIGHT();
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
