package groupId.bootstrap.wrapper.desktop.output;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWVidMode;

import groupId.bootstrap.wrapper.desktop.input.CursorPosInput;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public final class Window {

	private static Window instance;
	private static final int width = 1280;
	private static final int height = 720;

	private long window;
	private boolean initialized;

	private Window() {}

	public static Window getInstance() {
		if (instance == null) {
			instance = new Window();
			instance.init();
		}

		return instance;
	}

	public void init() {
		if (initialized) {
			return;
		}

		glfwInit();

		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

		window = glfwCreateWindow(width, height, "Bootstrap", NULL, NULL);

		GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

		glfwSetWindowPos(window, (vidMode.width() - width) / 2, (vidMode.height() - height) / 2);

		glfwMakeContextCurrent(window);
		glfwShowWindow(window);

		initialized = true;
	}

	public boolean render() {
		glfwSwapBuffers(window);
		return glfwWindowShouldClose(window);
	}

	public void update() {
		glfwPollEvents();
	}

	public void setKeyCallBack(GLFWKeyCallback keyCallBack) {
		glfwSetKeyCallback(window, keyCallBack);
	}

	public void setCursorPosCallBack(CursorPosInput cursorPosInput) {
		glfwSetCursorPosCallback(window, cursorPosInput);
	}
}
