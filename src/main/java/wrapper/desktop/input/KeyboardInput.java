package wrapper.desktop.input;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class KeyboardInput extends GLFWKeyCallback {

	public boolean[] keysDown = new boolean[65536];

	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		keysDown[key] = action != GLFW.GLFW_RELEASE;
	}
}
