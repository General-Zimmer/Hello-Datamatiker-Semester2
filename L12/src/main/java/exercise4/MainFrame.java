package exercise4;

import exercise4.handler_ting.HandlerList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.Getter;

public class MainFrame extends Application {
    private final GridPane pane = new GridPane();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Ex. 4: Observer Pattern");
        this.initContent(stage);
        stage.setMinWidth(300);

        Scene scene = new Scene(this.pane);
        stage.setScene(scene);
        stage.show();
    }

    // ------------------------------------------------------------------------

    private void initContent(Stage stage) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNumber = new Label("Number");
        pane.add(lblNumber, 0, 0);

        ToggleGroup group = new ToggleGroup();

        RadioButton rbnRed = new RadioButton("Red");
        pane.add(rbnRed, 0, 1);
        rbnRed.setToggleGroup(group);
        rbnRed.setOnAction(event -> this.redAction());

        RadioButton rbnGreen = new RadioButton("Green");
        pane.add(rbnGreen, 0, 2);
        rbnGreen.setToggleGroup(group);
        rbnGreen.setOnAction(event -> this.greenAction());

        RadioButton rbnBlue = new RadioButton("Blue");
        pane.add(rbnBlue, 0, 3);
        rbnBlue.setToggleGroup(group);
        rbnBlue.setOnAction(event -> this.blueAction());

        // ----- ME STUFF

        // Frame 1
        SubFrame subFrame1 = new SubFrame("SubFrame 1", stage);

        Button btnShowFrame1 = new Button("Open SubFrame 1");
        pane.add(btnShowFrame1, 0, 4);
        btnShowFrame1.setOnAction(event -> this.toggleShowSubFrame(subFrame1, btnShowFrame1));

        // Frame 2
        SubFrame subFrame2 = new SubFrame("SubFrame 2", stage);

        Button btnShowFrame2 = new Button("Open SubFrame 2");
        pane.add(btnShowFrame2, 0, 5);
        btnShowFrame2.setOnAction(event -> this.toggleShowSubFrame(subFrame2, btnShowFrame2));
    }

    // ------------------------------------------------------------------------

    private String color;
    @Getter
    private static final HandlerList handlerList = new HandlerList();

    private void redAction() {
        color = "pink";
        pane.setStyle("-fx-background-color: " + color);
        handlerList.updateAll(color);
    }

    private void greenAction() {
        color = "lightgreen";
        pane.setStyle("-fx-background-color: " + color);
        handlerList.updateAll(color);
    }

    private void blueAction() {
        color = "lightskyblue";
        pane.setStyle("-fx-background-color: " + color);
        handlerList.updateAll(color);
    }

    private void toggleShowSubFrame(SubFrame frame, Button button) {
        if (frame.isShowing()) {
            frame.hide();
            button.setText("Open " + frame.getTitle());
        } else {
            frame.show();
            button.setText("Close " + frame.getTitle());
        }
    }

}
