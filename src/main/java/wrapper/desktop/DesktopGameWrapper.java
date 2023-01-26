package wrapper.desktop;

import logging.DesktopLogger;
import view.DesktopGameView;
import wrapper.GameWrapper;
import wrapper.desktop.input.KeyboardInput;
import wrapper.desktop.input.CursorPosInput;
import wrapper.desktop.output.Window;

public class DesktopGameWrapper extends GameWrapper {

	private final KeyboardInput keyboardInput;
	private final CursorPosInput cursorPosInput;

	public DesktopGameWrapper(
			DesktopGameView gameView,
			DesktopLogger logger,
			KeyboardInput keyboardInput,
			CursorPosInput cursorPosInput) {
		super(gameView, logger);
		this.keyboardInput = keyboardInput;
		this.cursorPosInput = cursorPosInput;
	}

	@Override
	public void update() {
		Window.getInstance().update();
	}

	@Override
	public boolean render() {
		return Window.getInstance().render();
	}

	private void initWindow() {
		Window.getInstance().init();
	}

	private void setCallBacks() {
		Window.getInstance().setKeyCallBack(keyboardInput);
		Window.getInstance().setCursorPosCallBack(cursorPosInput);
	}

	public void setup() {
		initWindow();
		setCallBacks();
	}
}
