package fr.guinard.wargame.states;

import java.awt.Graphics;

import fr.guinard.wargame.Handler;
import fr.guinard.wargame.world.World;

public class GameState extends State {

	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "");
		handler.setWorld(world);
	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
