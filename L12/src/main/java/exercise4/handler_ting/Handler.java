package exercise4.handler_ting;

import exercise4.SubFrame;

public class Handler {
    private SubFrame subFrame;

    public Handler(SubFrame subFrame) {
        this.subFrame = subFrame;
    }

    public void update(String color) {
        subFrame.setStyle("-fx-background-color: " + color);
    }
}
