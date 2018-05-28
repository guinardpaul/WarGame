package fr.guinard.wargame.states;

import java.awt.Graphics;

import fr.guinard.wargame.Handler;

public abstract class State {

	private static State currentState = null;

	public static State getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(State currentState) {
		State.currentState = currentState;
	}

	protected Handler handler;

	public State(Handler handler) {
		this.handler = handler;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

}
