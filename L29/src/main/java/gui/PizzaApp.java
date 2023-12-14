package gui;

import controller.Controller;
import javafx.application.Application;

public class PizzaApp {
    public static void main(String[] args) {

        initStorage();
        Application.launch(PizzaWindow.class);
    }

    public static void initStorage() {
        Controller.createPizza("Robot Pizza", 69);
        Controller.createPizza("Paparoni Pizza", 50);
        Controller.createPizza("Yeeted Pizza", 1);
        Controller.createPizza("Military grade Pizza", 80);

    }
}
