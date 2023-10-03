package exercise4.handler_ting;

import java.util.HashSet;

public class HandlerList {

    private final HashSet<FrameHandler> frameHandlers = new HashSet<>();

    public void registerHandler(FrameHandler frameHandler) {
        frameHandlers.add(frameHandler);
    }

    public void unregisterHandler(FrameHandler frameHandler) {
        frameHandlers.remove(frameHandler);
    }

    public void update(String color) {
        for (FrameHandler frameHandler : frameHandlers) {
            frameHandler.update(color);
        }
    }


}
