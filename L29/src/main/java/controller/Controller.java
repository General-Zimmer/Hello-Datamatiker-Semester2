package controller;

import model.Pizza;
import observe.GuiUpdate;
import storage.ListStorage;

import java.util.HashSet;

public class Controller {

    private final static HashSet<GuiUpdate> guiUpdates = new HashSet<>();

    public static Pizza createPizza(String name, double prize) {
        Pizza pizza = new Pizza(name, prize);
        ListStorage.addPizza(pizza);
        updateGui();
        return pizza;
    }

    public static void registerGuiUpdate(GuiUpdate guiUpdate) {
        Controller.guiUpdates.add(guiUpdate);
    }

    public static void updateGui() {
        for (GuiUpdate gui : Controller.guiUpdates)
            gui.update();
    }

}
