package exercise4.handler_ting;

import java.util.HashSet;

public class HandlerList implements DoTheUpdate {

    private final HashSet<DoTheUpdate> frameHandlers = new HashSet<>();

    public void registerHandler(DoTheUpdate frameHandler) {
        frameHandlers.add(frameHandler);
    }

    public void unregisterHandler(DoTheUpdate frameHandler) {
        frameHandlers.remove(frameHandler);
    }

    @Override
    public void update(String color) {
        for (DoTheUpdate frameHandler : frameHandlers) {
            frameHandler.update(color);
        }
    }


}
