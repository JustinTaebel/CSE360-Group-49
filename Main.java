package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {
	
	Stage window;
	Scene loginPage, createAccountPage;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		// --------------------- Login Page --------------------- //
		
			// Asset Definition
		Label welcomeLabel = new Label("Welcome!");
		welcomeLabel.setFont(new Font("Arial", 80));
		
		Label pleaseSignInLabel = new Label("- Please Sign in -");
		pleaseSignInLabel.setFont(new Font("Arial", 30));
		
		Label usernameLabel = new Label("Username:");
		usernameLabel.setFont(new Font("Arial", 20));
		
		Label passwordLabel = new Label("Password:");
		passwordLabel.setFont(new Font("Arial", 20));
		
		TextField usernameField = new TextField();
		usernameField.setFont(new Font("Arial", 20));
		usernameField.setPromptText("Username");
		
		TextField passwordField = new TextField();
		passwordField.setFont(new Font("Arial", 20));
		passwordField.setPromptText("Password");
		
		Button loginButton = new Button("Login");
		loginButton.setFont(new Font("Arial", 20));
		
		Button createAccountButton = new Button("Create Account");
		createAccountButton.setFont(new Font("Arial", 20));
		createAccountButton.setOnAction(e -> {
			window.setScene(createAccountPage);
		});
			//
		
			// Login GridPane
		GridPane loginGrid = new GridPane();
		loginGrid.setAlignment(Pos.CENTER);
		
		loginGrid.setHgap(20);
		loginGrid.setVgap(20);
		loginGrid.setPadding(new Insets(10, 10, 10, 40));
		
		loginGrid.add(usernameLabel, 1, 1);
		loginGrid.add(usernameField, 2, 1);
		loginGrid.add(passwordLabel, 1, 2);
		loginGrid.add(passwordField, 2, 2);
			//
		
			// Login VBox
		VBox subButtonsVBox = new VBox(30);
		subButtonsVBox.getChildren().addAll(loginButton, createAccountButton);
		subButtonsVBox.setAlignment(Pos.CENTER);
		
		VBox loginVBox = new VBox(10);
		loginVBox.setAlignment(Pos.CENTER);
		loginVBox.getChildren().addAll(welcomeLabel, pleaseSignInLabel, loginGrid, subButtonsVBox);
		loginVBox.setPadding(new Insets(10, 10, 10, 10));
			//
		
		loginPage = new Scene(loginVBox, 600, 700);
		window.setScene(loginPage);
		
		
		// --------------------- Create Account Page --------------------- //
		
		// Asset Definition
		Label CALabel = new Label("Create An Account:");
		CALabel.setFont(new Font("Arial", 30));
		
		ComboBox<String> CATypeCombo = new ComboBox();
        CATypeCombo.getItems().addAll("Patient", "Doctor", "Nurse");
		
		Label CAFirstNameLabel = new Label("First Name");
		CAFirstNameLabel.setFont(new Font("Arial", 20));
		
		TextField CAFirstNameField = new TextField();
		CAFirstNameField.setFont(new Font("Arial", 20));
		CAFirstNameField.setPromptText("Enter First Name");
		
		Label CALastNameLabel = new Label("Last Name");
		CALastNameLabel.setFont(new Font("Arial", 20));
		
		TextField CALastNameField = new TextField();
		CALastNameField.setFont(new Font("Arial", 20));
		CALastNameField.setPromptText("Enter Last Name");
		
		Label CADateOfBirthLabel = new Label("Date of Birth");
		CADateOfBirthLabel.setFont(new Font("Arial", 20));
		
		TextField CADateOfBirthField = new TextField();
		CADateOfBirthField.setFont(new Font("Arial", 20));
		CADateOfBirthField.setPromptText("MM/DD/YYYY");
		
		Label CAPhoneNumLabel = new Label("Phone Number");
		CAPhoneNumLabel.setFont(new Font("Arial", 20));

		TextField CAPhoneNumField = new TextField();
		CAPhoneNumField.setFont(new Font("Arial", 20));
		CAPhoneNumField.setPromptText("XXX-XXX-XXXX");
		
		Button CACreateButton = new Button("Create");
		CACreateButton.setFont(new Font("Arial", 20));
		CACreateButton.setMinWidth(300);
		CACreateButton.setDefaultButton(true);
		
		//
		
		// CAGrid
		GridPane CAGrid = new GridPane();
		CAGrid.setAlignment(Pos.CENTER);
		CAGrid.setHgap(20);
		CAGrid.setVgap(20);
		CAGrid.setPadding(new Insets(10, 10, 10, 40));
		
		CAGrid.add(CAFirstNameLabel, 1, 1);
		CAGrid.add(CAFirstNameField, 2, 1);
		CAGrid.add(CALastNameLabel, 1, 2);
		CAGrid.add(CALastNameField, 2, 2);
		CAGrid.add(CADateOfBirthLabel, 1, 3);
		CAGrid.add(CADateOfBirthField, 2, 3);
		CAGrid.add(CAPhoneNumLabel, 1, 4);
		CAGrid.add(CAPhoneNumField, 2, 4);
		//
		
		// CAVBox
		VBox CAVBox = new VBox(10);
		CAVBox.setAlignment(Pos.CENTER);
		CAVBox.getChildren().addAll(CALabel, CAGrid, CACreateButton);
		CAVBox.setPadding(new Insets(10, 10, 10, 10));
		//
		
		
		createAccountPage = new Scene(CAVBox, 600, 700);
		
		// ---
		
		window.show();
	}
	
	
	
}
