package gui;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import observe.GuiUpdate;

public class PizzaInputWindow extends Stage implements GuiUpdate {

	TextField tfNavn;
	TextField tfPris;

	public PizzaInputWindow(String title, Stage owner) {
		this.initOwner(owner);
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setMinHeight(100);
		this.setMinWidth(200);
		this.setResizable(false);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);

	}

	// -------------------------------------------------------------------------

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		pane.add(new Label("Navn:"), 0, 0);
		pane.add(new Label("Pris: "), 0, 1);

		tfNavn = new TextField("Gib navn");
		pane.add(tfNavn, 1, 0);

		tfPris = new TextField("Gib pris");
		pane.add(tfPris, 1, 1);

		Button button = new Button("Lav pizza");
		pane.add(button, 0, 2);
		button.setOnAction(this::lavPizza);
	}

	private void lavPizza(ActionEvent event) {
		Controller.createPizza(tfNavn.getText(), Double.parseDouble(tfPris.getText()));
		this.hide();
	}

	@Override
	public void update() {
		tfPris.clear();
		tfNavn.clear();
	}
}
