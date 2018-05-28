/*
 * 
 */
package fr.guinard.wargame.entities.mob;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fr.guinard.wargame.Handler;
import fr.guinard.wargame.gfx.Animation;
import fr.guinard.wargame.gfx.Assets;

/**
 * The Class Player.
 */
public class Player extends Mob {

	/** The animation. */
	private Animation animDown, animUp, animLeft, animRight;

	/**
	 * Instantiates a new player.
	 *
	 * @param handler
	 *            the handler
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public Player(Handler handler, int x, int y) {
		super(handler, x, y, Mob.DEFAULT_MOB_WIDTH, Mob.DEFAULT_MOB_HEIGHT);
		// Animations
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.guinard.wargame.entities.Entity#tick()
	 */
	@Override
	public void tick() {
		// Animations
		animDown.tick();
		animLeft.tick();
		animRight.tick();
		animUp.tick();
		// Movement
		getKeyInput();
		move();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.guinard.wargame.entities.Entity#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), x, y, width, height, null);
	}

	/**
	 * Gets the key input.
	 */
	private void getKeyInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up) {
			yMove = -speed;
		}
		if (handler.getKeyManager().down) {
			yMove = speed;
		}
		if (handler.getKeyManager().left) {
			xMove = -speed;
		}
		if (handler.getKeyManager().right) {
			xMove = speed;
		}
	}

	/**
	 * Gets the current animation frame.
	 *
	 * @return the current animation frame
	 */
	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			return animUp.getCurrentFrame();
		} else if (yMove > 0) {
			return animDown.getCurrentFrame();
		} else {
			return Assets.player_down[0];
		}
	}

}
