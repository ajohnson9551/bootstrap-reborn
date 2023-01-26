package groupId.bootstrap.wrapper;

import groupId.bootstrap.logging.Logger;
import groupId.bootstrap.view.GameView;

public abstract class GameWrapper implements Runnable {

	private Thread thread;
	Logger logger;

	private final long MAX_TPS = 30;
	private long tickDebt = 0;
	private long timeOfLastTick = System.currentTimeMillis();

	GameView gameView;

	public GameWrapper(GameView gameView, Logger logger) {
		this.gameView = gameView;
		this.logger = logger;
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
		
		tickDebt += ((curTime - timeOfLastTick) * MAX_TPS) / 1000L;
		
		if (tickDebt == 0) {
			return;
		}

		if (tickDebt > 1) {
			logger.warn("Running behind! TickDebt = " + tickDebt);
		}

		sendTick();
		tickDebt--;
		timeOfLastTick = System.currentTimeMillis();
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
		timeOfLastTick = System.currentTimeMillis();
		mainLoop();
	}
}
