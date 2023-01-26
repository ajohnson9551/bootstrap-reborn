package groupId.bootstrap.wrapper.desktop;

import groupId.bootstrap.logging.DesktopLogger;
import groupId.bootstrap.view.DesktopGameView;
import groupId.bootstrap.wrapper.GameWrapper;
import groupId.bootstrap.wrapper.desktop.input.CursorPosInput;
import groupId.bootstrap.wrapper.desktop.input.KeyboardInput;
import groupId.bootstrap.wrapper.desktop.output.Window;

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

	@Override
	public void setup() {
		initWindow();
		setCallBacks();
	}
}
