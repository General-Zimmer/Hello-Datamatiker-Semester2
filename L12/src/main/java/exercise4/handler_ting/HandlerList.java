package exercise4.handler_ting;

import java.util.HashSet;

public class HandlerList implements DoTheUpdate {

    private final HashSet<DoTheUpdate> handlers = new HashSet<>(); // Observers

    public void registerHandler(DoTheUpdate frameHandler) {
        handlers.add(frameHandler);
    }

    public void unregisterHandler(DoTheUpdate frameHandler) {
        handlers.remove(frameHandler);
    }

    @Override
    public void update(String color) {
        for (DoTheUpdate frameHandler : handlers) {
            frameHandler.update(color);
        }
    }


}
