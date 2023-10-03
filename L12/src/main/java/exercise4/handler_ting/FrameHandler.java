package exercise4.handler_ting;

import exercise4.MainFrame;
import exercise4.SubFrame;

public class FrameHandler implements DoTheUpdate {
    private final SubFrame subFrame;

    public FrameHandler(SubFrame subFrame) {
        this.subFrame = subFrame;
    }

    @Override
    public void update(String color) {
        subFrame.setStyle("-fx-background-color: " + color);
    }

    public void subscribe() {
        MainFrame.getHandlerList().registerHandler(this);
    }

    public void unsubscribe() {
        MainFrame.getHandlerList().unregisterHandler(this);
    }
}
