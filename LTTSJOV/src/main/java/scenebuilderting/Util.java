package scenebuilderting;

import javafx.scene.control.Control;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import scenebuilderting.gui.App;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Util {
    /**
     * Moves a node to a random location on the pane, but not inside the reference node or outside the pane
     * @param pane The pane to move the node on
     * @param moved The node to move
     * @param reference The node to not move the node too close to
     */
    public static void moveNodeRandom(Pane pane, Control moved, Control reference) {
        double x;
        double y;
        double layoutX = reference.getLayoutX();
        double layoutY = reference.getLayoutY();
        double width = reference.widthProperty().get();
        double height = reference.heightProperty().get();
        int tries = 0;
        do {
            if (tries > 1000) {
                pane.setLayoutY(pane.getHeight()+height*0.1);
                pane.setLayoutX(pane.getWidth()+width*0.3);
                pane.snapshot(null, null);
                tries = 0;
            }

            x = pane.getWidth() * Math.random();
            y = pane.getHeight() * Math.random();
            tries++;

        } while ((x > layoutX - width &&
                x < layoutX + width &&
                y > layoutY - height &&
                y < layoutY + height)
                || x < 0 || y < 0 ||
                x+width > pane.getWidth() || y+height > pane.getHeight());

        moved.setLayoutX(x);
        moved.setLayoutY(y);
        System.out.println("tries " + tries);
        System.out.println("width: " + width + " Height: " + height);
        System.out.println(moved.styleProperty());


    }

    /**
     * Gets a MediaPlayer from a file
     * Note: The file must be in the resource folder otherwise the audio file will never be found.
     * @param fileName The name of the file to get the MediaPlayer from
     * @return The MediaPlayer from the file
     */
    public static MediaPlayer getMediaPlayerFromFile(String fileName) {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL is = classloader.getResource(fileName);


        Media media = new Media(is.toString());


        return new MediaPlayer(media);
    }
}
