
import java.time.LocalDate;
import java.util.Optional;

/**
 * This app should contain all elements by the end of Sprint 2
 * The starter code only shows the minimum 
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainGUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	private LoginPane loginPane;
	private BorderPane everything;

	@Override
	public void start(Stage primaryStage) throws Exception {

		LayoutGUI();
		Scene scene = new Scene(everything, 800, 900);
		primaryStage.setScene(scene);

		primaryStage.setResizable(false);
		primaryStage.show();

	}

	private void LayoutGUI() {
		everything = new BorderPane();
		loginPane = new LoginPane();

		loginPane.setPadding(new Insets(10));
		everything.setBottom(loginPane);

	}

}
