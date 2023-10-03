package exercise4;

import exercise4.handler_ting.FrameHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SubFrame extends Stage {
    private final GridPane pane = new GridPane();
    private FrameHandler frameHandler = new FrameHandler(this);

    public SubFrame(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        this.initContent();

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final Label lblInfo =  new Label("State: Unsubscribed");

    private void initContent() {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblHeader = new Label("Computer Science is colorful");
        pane.add(lblHeader, 0, 0);

        Button btnSubscribe = new Button("Subscribe");
        pane.add(btnSubscribe, 0, 1);
        btnSubscribe.setOnAction(event -> this.subscribe());

        Button btnUnsubscribe = new Button("Unsubscribe");
        pane.add(btnUnsubscribe, 0, 2);
        btnUnsubscribe.setOnAction(event -> this.unsubscribe());

        pane.add(this.lblInfo, 0, 3);
    }

    public void subscribe() {
        this.lblInfo.setText("State: Subscribed");
        this.frameHandler.subscribe();
    }

    public void unsubscribe() {
        this.lblInfo.setText("State: Unsubscribed");
        this.frameHandler.unsubscribe();
    }

    public void setStyle(String style) {
        this.pane.setStyle(style);
    }
}
