package groupId.bootstrap.view;

import groupId.bootstrap.engine.GameEngine;

public abstract class GameView {

	GameEngine gameEngine;

	public GameView(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}
}
