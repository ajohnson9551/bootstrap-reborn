package groupId.bootstrap.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import groupId.bootstrap.engine.GameEngine;
import groupId.bootstrap.logging.DesktopLogger;
import groupId.bootstrap.view.DesktopGameView;

public class TestGameWrapper {

    @Test
    public void shouldSetupUpdateRenderInOrder() {
        StubGameWrapper wrapper = new StubGameWrapper(
                new DesktopGameView(new GameEngine()),
                new DesktopLogger());

        wrapper.run();

        assertEquals(1, wrapper.getSetupOrder());
        assertEquals(2, wrapper.getUpdateOrder());
        assertEquals(3, wrapper.getRenderOrder());
    }
}
