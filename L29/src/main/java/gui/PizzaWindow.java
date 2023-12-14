package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Pizza;
import observe.GuiUpdate;
import storage.ListStorage;

import java.util.ArrayList;

public class PizzaWindow extends Application implements GuiUpdate {

	private ListView<Pizza> lwPizza;
	private Button buttLavPizza;
	private PizzaInputWindow inputWindow;

	@Override
	public void start(Stage stage) {
		stage.setTitle("Pizzaer");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblComp = new Label("Liste over pizzaer");
		pane.add(lblComp, 0, 0);

		lwPizza = new ListView<>();
		pane.add(lwPizza, 0, 1);


		buttLavPizza = new Button("Lav Pizza");
		pane.add(buttLavPizza, 0, 2);
		buttLavPizza.setOnAction(this::lavPizzaButton);

		inputWindow = new PizzaInputWindow("Opret pizza", new Stage());

		Controller.registerGuiUpdate(inputWindow);
		Controller.registerGuiUpdate(this);

		update();
	}

	private void lavPizzaButton(ActionEvent action) {
		inputWindow.show();
	}

	@Override
	public void update() {
		lwPizza.getItems().clear();
		ArrayList<Pizza> pizzas = ListStorage.getPizza();
		for (Pizza pizza : pizzas) {
			lwPizza.getItems().add(pizza);
		}
	}
}
