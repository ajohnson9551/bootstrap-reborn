package groupId.bootstrap.wrapper.desktop.input;

import org.lwjgl.glfw.GLFWCursorPosCallback;

public class CursorPosInput extends GLFWCursorPosCallback {

	public double[] cursorPos = new double[2];

	@Override
	public void invoke(long window, double posX, double posY) {
		cursorPos[0] = posX;
		cursorPos[1] = posY;
	}
}
