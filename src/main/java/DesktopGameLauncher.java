import engine.GameEngine;
import logging.DesktopLogger;
import view.DesktopGameView;
import wrapper.GameWrapper;
import wrapper.desktop.DesktopGameWrapper;
import wrapper.desktop.input.KeyboardInput;
import wrapper.desktop.input.CursorPosInput;

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