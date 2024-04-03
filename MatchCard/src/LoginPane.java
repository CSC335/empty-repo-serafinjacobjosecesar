import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginPane extends BorderPane {

	private Label userName = new Label("Account Name");
	private TextField nameEntry = new TextField();
	private Label password = new Label("Password");
	private PasswordField passEntry = new PasswordField();
	private Button login = new Button("Login");
	private Button logout = new Button("Logout");
	private Label sysReply = new Label();


	public LoginPane() {

		VBox loginComps = configLogin();
		this.setCenter(loginComps);

	}

	private VBox configLogin() {
		VBox loginFields = new VBox();
		HBox userNameField = new HBox();
		HBox passwordField = new HBox();
		HBox playButtonField = new HBox();

		userNameField.getChildren().addAll(userName, nameEntry);
		passwordField.getChildren().addAll(password, passEntry);
		HBox.setMargin(userName, new Insets(20, 5, 5, 30));
		HBox.setMargin(nameEntry, new Insets(20, 30, 5, 5));
		HBox.setMargin(password, new Insets(10, 5, 10, 30));
		HBox.setMargin(passEntry, new Insets(10, 30, 15, 5));

		userNameField.setAlignment(Pos.CENTER);
		passwordField.setAlignment(Pos.CENTER);
		playButtonField.setAlignment(Pos.CENTER);

		loginFields.getChildren().addAll(playButtonField, userNameField, passwordField, login, sysReply, logout);
		loginFields.setAlignment(Pos.CENTER);

		return loginFields;
	}

}
