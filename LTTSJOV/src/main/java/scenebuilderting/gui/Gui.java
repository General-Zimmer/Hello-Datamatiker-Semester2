package scenebuilderting.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Gui extends Application {
    @SuppressWarnings("ConstantConditions")
    @Override
    public void start(Stage stage) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getClassLoader().getResource("first.fxml"));
        Scene scene = new Scene(fxmlLoader);
        stage.setTitle("Zimmah");
        stage.setScene(scene);
        stage.show();
    }




}