package wrapper;

import logging.Logger;
import view.GameView;

public abstract class GameWrapper implements Runnable {

	private Thread thread;
	Logger logger;

	private long MAX_TPS = 20;
	private long MS_PER_TICK;
	private long tickDebt = 0;
	private long lastTickAccrualTime;

	GameView gameView;

	public GameWrapper(GameView gameView, Logger logger) {
		this.gameView = gameView;
		this.logger = logger;

		this.MS_PER_TICK = 1000L / MAX_TPS;
	}

	public abstract void setup();
	public abstract void update();
	public abstract boolean render();

	public final void launchGame() {
		thread = new Thread(this, "Bootstrap");
		thread.start();
	}

	private void tryTick() {
		long curTime = System.currentTimeMillis();

		long addTicks = (curTime - lastTickAccrualTime) / MS_PER_TICK;
		tickDebt += addTicks;
		lastTickAccrualTime += addTicks * MS_PER_TICK;

		if (tickDebt == 0) {
			return;
		}

		sendTick();
		tickDebt--;

		if (tickDebt > 0) {
			logger.warn("Running behind! TickDebt = " + tickDebt);
		}
	}
	
	private void sendTick() {
		logger.test("Tick!");
	}

	public final void mainLoop() {
		while (true) {
			update();

			tryTick();

			if (render()) {
				break;
			}
		}
	}

	@Override
	public final void run() {
		setup();
		lastTickAccrualTime = System.currentTimeMillis();
		mainLoop();
	}
}
