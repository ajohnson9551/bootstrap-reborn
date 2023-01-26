package groupId.bootstrap;

import groupId.bootstrap.engine.GameEngine;
import groupId.bootstrap.logging.DesktopLogger;
import groupId.bootstrap.view.DesktopGameView;
import groupId.bootstrap.wrapper.GameWrapper;
import groupId.bootstrap.wrapper.desktop.DesktopGameWrapper;
import groupId.bootstrap.wrapper.desktop.input.CursorPosInput;
import groupId.bootstrap.wrapper.desktop.input.KeyboardInput;

public class DesktopGameLauncher {

	public static void main(String[] args) {
		GameWrapper gameWrapper = new DesktopGameWrapper(
				new DesktopGameView(
						new GameEngine()),
				new DesktopLogger(),
				new KeyboardInput(),
				new CursorPosInput());

		gameWrapper.launchGame();
	}
}
