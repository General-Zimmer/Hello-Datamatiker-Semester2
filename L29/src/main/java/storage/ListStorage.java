package storage;

import gui.PizzaApp;
import model.Pizza;

import java.util.ArrayList;

public class ListStorage {

   private static final ArrayList<Pizza> pizzas = new ArrayList<>();



   public static void addPizza(Pizza pizza) {
       pizzas.add(pizza);
   }
   public static ArrayList<Pizza> getPizza() {
       return new ArrayList<>(pizzas);
   }
}
