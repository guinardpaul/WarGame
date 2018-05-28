package fr.guinard.wargame.entities;

import java.awt.Graphics;

import fr.guinard.wargame.Handler;

public abstract class Entity {

	protected Handler handler;
	/** X, Y Position */
	protected int x, y;
	/** Width, Height */
	protected int width, height;

	public Entity(Handler handler, int x, int y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

}
