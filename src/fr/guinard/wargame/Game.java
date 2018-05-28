package fr.guinard.wargame;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import fr.guinard.wargame.gfx.Assets;
import fr.guinard.wargame.input.KeyManager;
import fr.guinard.wargame.states.GameState;
import fr.guinard.wargame.states.MenuState;
import fr.guinard.wargame.states.State;
import fr.guinard.wargame.world.World;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private final int WIDTH = 360;
	private final int HEIGHT = WIDTH / 12 * 9;
	private final int SCALE = 3;
	private final String TITLE = "War Machines";

	private JFrame frame;
	private Thread thread;
	private boolean running;

	// States
	private State gameState;
	private State menuState;

	// Handler
	private Handler handler;

	// Input
	private KeyManager keyManager;

	private World world;

	public Game() {
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		// Input
		keyManager = new KeyManager();

		frame = new JFrame(TITLE);
		frame.setResizable(false);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void init() {
		addKeyListener(keyManager);
		Assets.init();

		handler = new Handler(this);

		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setCurrentState(gameState);
	}

	private void tick() {
		if (State.getCurrentState() != null) {
			State.getCurrentState().tick();
		}
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

		if (State.getCurrentState() != null) {
			State.getCurrentState().render(g);
		}

		bs.show();
		g.dispose();
	}

	@Override
	public void run() {
		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("Ticks " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();
	}

	public static void main(String[] args) {
		Game gameComponent = new Game();

		gameComponent.start();
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this, "Game thread");
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
