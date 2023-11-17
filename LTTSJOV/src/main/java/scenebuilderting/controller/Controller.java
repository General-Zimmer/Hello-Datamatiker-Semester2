package scenebuilderting.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import scenebuilderting.Util;

public class Controller {

    @FXML
    private Button yeetButt;
    @FXML
    private Button random_button;
    @FXML
    private ColorPicker color;
    @FXML
    private Label theYeet;
    @FXML
    private AnchorPane funPane;
    @FXML
    private AnchorPane ltt_pane;
    @FXML
    private MediaView crapWindow;

    private int movedCount = 0;
    private final MediaPlayer crapPlayer;
    private final MediaPlayer screwPlayer;

    public Controller() {
        // Load the sound files
        crapPlayer = Util.getMediaPlayerFromFile("craps.mp4");
        screwPlayer = Util.getMediaPlayerFromFile("screw_u.mp3");

    }

    @FXML
    public void onYeetPress() {
        // Switch between YEET and UnYEET
        if (theYeet.getText().equals("")) {
            // Move theYeet to another location
            Util.moveNodeRandom(funPane, theYeet, yeetButt);
            theYeet.setText("YEET");
            yeetButt.setText("UnYEET");
        } else {
            yeetButt.setText("the YEET");
            theYeet.setText("");
        }
    }

    //todo add volume slider
    @FXML
    public void startCrabRave() {
        crapPlayer.play();
        if (crapWindow.getMediaPlayer() == null) {
            crapWindow.setMediaPlayer(crapPlayer);
            double height = crapWindow.getFitHeight();
            double heightRatio = 1.775;
            crapWindow.setFitWidth(heightRatio * height);
        } else {
            crapWindow.setVisible(true);
        }
    }

    @FXML
    public void stopCrabRave() {
        crapPlayer.stop();
        crapWindow.setVisible(false);
    }

    @FXML
    public void onMouseOver() {
        // Hide random_button after 20 moves
        if (movedCount > 19) {
            random_button.setVisible(false);
            return;
        }


        // Change text
        switch (movedCount) {
            case 0 -> random_button.setText("Aye! I'm just a button!");
            case 1 -> random_button.setText("You almost touched me");
            case 2 -> random_button.setText("Stop it!");
            case 3 -> random_button.setText("I'm warning you!");
            case 4 -> random_button.setText("I'm gonna disappear if you keep going!");
            case 5 -> random_button.setText("Whyyy");
            case 6 -> random_button.setText("Go away!");
            case 7 -> random_button.setText("AHHHH STTOOOOPPP");
            case 8 -> random_button.setText("AHHH");
            case 9 -> random_button.setText("AHHHHHHHH!");
            case 12 -> random_button.setText("AHHHHHHHH, fuck yoooou");
            case 13 -> random_button.setText("REEEEEEEEEEEEEEEEEEEEeeeeeeEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEeeeeeeEEEEEEEEEEEEeeEEEEEEEEEEE");
            case 14 -> random_button.setText("Just leave me aloooone!");
            case 15 -> random_button.setText("stop meanie!");
            case 16 -> random_button.setText("Get a life");
            case 17 -> random_button.setText("And touch grass (Not me)");
            case 18 -> random_button.setText("You filthy animal!");
            case 19 -> random_button.setText("screw you, I am gonna go play Mine-craft!");
        }
        movedCount++;


        // Update pane so the button size is up to date before move is calculated.
        funPane.snapshot(null, null);

        // todo automatically hide button when player is done
        // play media when
        if (movedCount == 19+1)
            screwPlayer.play();


        // Move random_button to another location
        Util.moveNodeRandom(funPane, random_button, random_button);

    }

    @FXML
    public void onColorPicked() {
        yeetButt.setStyle("-fx-background-color: #" + color.getValue().toString().substring(2));
        random_button.setStyle("-fx-background-color: #" + color.getValue().toString().substring(2));
        
    }
}
