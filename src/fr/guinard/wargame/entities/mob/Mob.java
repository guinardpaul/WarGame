package fr.guinard.wargame.entities.mob;

import fr.guinard.wargame.Handler;
import fr.guinard.wargame.entities.Entity;

public abstract class Mob extends Entity {

	public static final int DEFAULT_HEALTH = 100;
	public static final float DEFAULT_SPEED = 3f;
	public static final int DEFAULT_MOB_WIDTH = 64;
	public static final int DEFAULT_MOB_HEIGHT = 64;

	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Mob(Handler handler, int x, int y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public void move() {
		x += xMove;
		y += yMove;
	}

}
