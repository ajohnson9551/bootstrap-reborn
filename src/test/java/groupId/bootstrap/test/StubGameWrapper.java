package groupId.bootstrap.test;

import groupId.bootstrap.logging.Logger;
import groupId.bootstrap.view.GameView;
import groupId.bootstrap.wrapper.GameWrapper;

public class StubGameWrapper extends GameWrapper {

    private int order = 0;

    private int renderOrder = 0;
    private int updateOrder = 0;
    private int setupOrder = 0;

    public StubGameWrapper(GameView gameView, Logger logger) {
        super(gameView, logger);
    }

    @Override
    public void setup() {
        order++;
        setupOrder = order;
    }

    @Override
    public void update() {
        order++;
        updateOrder = order;
    }

    @Override
    public boolean render() {
        order++;
        renderOrder = order;
        return true;
    }

    public int getRenderOrder() {
        return renderOrder;
    }

    public int getUpdateOrder() {
        return updateOrder;
    }

    public int getSetupOrder() {
        return setupOrder;
    }
    
}
