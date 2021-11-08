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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {
	
	Stage window;
	Scene loginPage, createAccountPage, doctorSelectPatient, doctorScene, nurseStart;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// ---------------------------------- Login Page ---------------------------------- //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		// ------------ Asset Definition ------------ //
		Label loginWelcomeLabel = new Label("Welcome!");
		loginWelcomeLabel.setFont(new Font("Arial", 80));
		
		Label loginSignInLabel = new Label("- Please Sign in -");
		loginSignInLabel.setFont(new Font("Arial", 30));
		
		Label loginUsernameLabel = new Label("Username:");
		loginUsernameLabel.setFont(new Font("Arial", 20));
		
		Label loginPasswordLabel = new Label("Password:");
		loginPasswordLabel.setFont(new Font("Arial", 20));
		
		TextField loginUsernameField = new TextField();
		loginUsernameField.setFont(new Font("Arial", 20));
		loginUsernameField.setPromptText("Username");
		
		TextField loginPasswordField = new TextField();
		loginPasswordField.setFont(new Font("Arial", 20));
		loginPasswordField.setPromptText("Password");
		
		Button loginButton = new Button("Login");
		loginButton.setFont(new Font("Arial", 20));
		loginButton.setDefaultButton(true);
		loginButton.setOnAction(e -> {
			if (loginUsernameField.getText().equals("doctor")) {
				window.setScene(doctorSelectPatient);
			}
		});
		
		Button loginCreateButton = new Button("Create Account");
		loginCreateButton.setFont(new Font("Arial", 20));
		loginCreateButton.setOnAction(e -> {
			window.setScene(createAccountPage);
		});
		
		
		// ------------ Login Grid Pane ------------ //
		GridPane loginGrid = new GridPane();
		loginGrid.setAlignment(Pos.CENTER);
		
		loginGrid.setHgap(20);
		loginGrid.setVgap(20);
		loginGrid.setPadding(new Insets(10, 10, 10, 40));
		
		loginGrid.add(loginUsernameLabel, 1, 1);
		loginGrid.add(loginUsernameField, 2, 1);
		loginGrid.add(loginPasswordLabel, 1, 2);
		loginGrid.add(loginPasswordField, 2, 2);
		
		// ------------ Login Vbox ------------ //
		VBox loginButtonsVBox = new VBox(30);
		loginButtonsVBox.getChildren().addAll(loginButton, loginCreateButton);
		loginButtonsVBox.setAlignment(Pos.CENTER);
		
		VBox loginVBox = new VBox(10);
		loginVBox.setAlignment(Pos.CENTER);
		loginVBox.getChildren().addAll(loginWelcomeLabel, loginSignInLabel, loginGrid, loginButtonsVBox);
		loginVBox.setPadding(new Insets(10, 10, 10, 10));
		
		// ---------- Scene Stuff ---------- //
		loginPage = new Scene(loginVBox, 600, 700);
		window.setScene(loginPage);
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// ----------------------------- Create Account Page ------------------------------ //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		// ------------ Asset Definition ------------ //
		Label CALabel = new Label("Create An Account:");
		CALabel.setFont(new Font("Arial", 30));
		
		ComboBox<String> CATypeCombo = new ComboBox<String>();
		CATypeCombo.setPromptText("Choose Account Type");
        CATypeCombo.getItems().addAll("Patient", "Doctor", "Nurse");
		CATypeCombo.setMinWidth(200);
		CATypeCombo.setMinHeight(30);
		
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
		
		Button CABackButton = new Button("Back To Login");
		CABackButton.setFont(new Font("Arial", 14));
		CABackButton.setOnAction(e -> {
			window.setScene(loginPage);
		});
		
		
		// ------------ CAGrid ------------ //
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
		
		
		// ------------ CAVBox ------------ //
		VBox CAVBox = new VBox(10);
		CAVBox.setAlignment(Pos.CENTER);
		CAVBox.getChildren().addAll(CALabel, CAGrid, CATypeCombo, CACreateButton, CABackButton);
		CAVBox.setPadding(new Insets(10, 10, 10, 10));
		
		// ---------- Scene Stuff ---------- //
		createAccountPage = new Scene(CAVBox, 600, 700);
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// --------------------------------- Doctor Page ---------------------------------- //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		// ===================================== Doctor Start ===================================== //
		// ------------ Asset Definition ------------ //
		ComboBox<String> doctorPatientListCombo = new ComboBox<String>();
		doctorPatientListCombo.setPromptText("Select Patient");
		// for patient in patientList:
		// doctorPatientListCombo.add(patient.getName());
		doctorPatientListCombo.getItems().addAll("George Person");

		Button doctorPatientNextButton = new Button("Next");
		doctorPatientNextButton.setFont(new Font("Arial", 14));
		doctorPatientNextButton.setOnAction(e -> {
			// currentPatient = patient
			window.setScene(doctorScene);
		});
		
		Label doctorWelcome = new Label("Hello Dr. (name) - Which patient are you seeing today?"); 
		doctorWelcome.setFont(new Font("Arial", 20));
		
		// ----------- doctorSelectPatientGrid ---------- //
		VBox doctorSelectPatientVBox = new VBox();
		doctorSelectPatientVBox.setPadding(new Insets(40, 40, 40, 40));
		doctorSelectPatientVBox.getChildren().addAll(doctorWelcome, doctorPatientListCombo, doctorPatientNextButton);
		
		// ---------- Scene Stuff ---------- //
		doctorSelectPatient = new Scene(doctorSelectPatientVBox, 600, 700);
		
		// ================================= General DoctorScene ================================= //
		
		// ---------- Assets ------- //
		Label doctorPatientNameLabel = new Label("            Patient Name");
		doctorPatientNameLabel.setFont(new Font("Arial", 20));
		
		Button doctorExamButton = new Button("Examination");
		doctorExamButton.setFont(new Font("Arial", 16));
		
		Button doctorHistoryButton = new Button("History");
		doctorHistoryButton.setFont(new Font("Arial", 16));
		
		Button doctorContactInfoButton = new Button("Contact Info");
		doctorContactInfoButton.setFont(new Font("Arial", 16));
		
		Button doctorMessagesButton = new Button("Messages");
		doctorMessagesButton.setFont(new Font("Arial", 16));
		
		Button doctorSelectDifPatientButton = new Button("Select A Different Patient");
		doctorSelectDifPatientButton.setFont(new Font("Arial", 20));
		
		// BUTTON FUNCTION AT BOTTOM OF DOCTOR PAGE //
		
		// ------------ doctorPatientVBox ----------- //
		VBox doctorPatientVBox = new VBox();
		doctorPatientVBox.setPadding(new Insets(10, 10, 10, 10));
		doctorPatientVBox.getChildren().addAll(doctorExamButton, doctorHistoryButton, doctorContactInfoButton, doctorMessagesButton);
		
		// ----------- doctorBorder ---------- //
		BorderPane doctorBorder = new BorderPane();
		doctorBorder.setTop(doctorPatientNameLabel);
		doctorBorder.setLeft(doctorPatientVBox);
		doctorBorder.setBottom(doctorSelectDifPatientButton);
		doctorBorder.setPadding(new Insets(10, 10, 10, 10));
		
		// ---------- Scene Stuff ------------ //
		doctorScene = new Scene(doctorBorder, 600, 700);
		
		// ===================================== Doctor Exam ===================================== //
		
		// --------- Asset Definition -------- //
		Label doctorPhysicalLabel = new Label("Physical Test Findings:");
		doctorPhysicalLabel.setFont(new Font("Arial", 20));
		
		TextField doctorPhysicalField = new TextField();
		doctorPhysicalLabel.setFont(new Font("Arial", 12));
		doctorPhysicalField.setPromptText("Enter Physical Findings");
		
		Label doctorPrescriptionsLabel = new Label("Prescriptions:");
		doctorPrescriptionsLabel.setFont(new Font("Arial", 20));
		
		TextField doctorPrescriptionsField = new TextField();
		doctorPrescriptionsField.setFont(new Font("Arial", 12));
		doctorPrescriptionsField.setPromptText("Enter Prescriptions");
		
		// -------- doctorExamGrid ------- //
		GridPane doctorExamGrid = new GridPane();
		doctorExamGrid.add(doctorPhysicalLabel, 0, 0);
		doctorExamGrid.add(doctorPhysicalField, 1, 0);
		doctorExamGrid.add(doctorPrescriptionsLabel, 0, 1);
		doctorExamGrid.add(doctorPrescriptionsField, 1, 1);
		
		
		// -------- doctorBorder Manipulation -------- //
		doctorBorder.setCenter(doctorExamGrid);
		
		// ===================================== Doctor History ===================================== //
		
		// --------- Asset Definition -------- //
		Label doctorPatientHistoryLabel = new Label("Patient History:");
		doctorPhysicalLabel.setFont(new Font("Arial", 20));
		
		Label doctorPriorHealthIssuesLabel = new Label("Prior Health Issues:");
		doctorPrescriptionsLabel.setFont(new Font("Arial", 16));
		
		Label doctorPriorMedicationsLabel = new Label("Prior Medications:");
		doctorPrescriptionsLabel.setFont(new Font("Arial", 16));
		
		Label doctorImmRecordsLabel = new Label("Immunization Records:");
		doctorPrescriptionsLabel.setFont(new Font("Arial", 16));
		
		// -------- doctorHistoryVBox ------- //
		VBox doctorHistoryVBox = new VBox();
		doctorHistoryVBox.getChildren().addAll(doctorPatientHistoryLabel, doctorPriorHealthIssuesLabel,
												doctorPriorMedicationsLabel, doctorImmRecordsLabel);
		
		// ===================================== Doctor Contact Info ===================================== //
		
		// --------- Asset Definition -------- //
		Label doctorContactInfoLabel = new Label("Contact Info:");
		doctorPhysicalLabel.setFont(new Font("Arial", 20));
		
		Label doctorPersonalContactLabel = new Label("Personal Contact:");
		doctorPrescriptionsLabel.setFont(new Font("Arial", 16));
		
		Label doctorPharmacyContactLabel = new Label("Pharmacy Contact:");
		doctorPrescriptionsLabel.setFont(new Font("Arial", 16));
		
		Label doctorInsuranceContactLabel = new Label("Insurance Contact");
		doctorPrescriptionsLabel.setFont(new Font("Arial", 16));
		
		// -------- doctorContactInfoVBox ------- //
		VBox doctorContactInfoVBox = new VBox();
		doctorContactInfoVBox.getChildren().addAll(doctorContactInfoLabel, doctorPersonalContactLabel,
												doctorPharmacyContactLabel, doctorInsuranceContactLabel);
		
		// ===================================== Doctor Messages ===================================== //
		
		
		// --------- Asset Definition -------- //
		Label doctorMessagesLabel = new Label("Messages");
		doctorMessagesLabel.setFont(new Font("Arial", 20));
		
		Label doctorMessageText = new Label("Messages to and from patient here");
		doctorMessageText.setFont(new Font("Arial", 16));
		
		TextField doctorMessageField = new TextField();
		doctorMessageField.setPromptText("Enter Message");
		
		Button doctorSendMessageButton = new Button("Send");
		doctorSendMessageButton.setFont(new Font("Arial", 20));
		doctorSendMessageButton.setOnAction(e -> {
			// Add to messages List
			doctorMessageField.clear();
			// MAKE SURE TO REFRESH MESSAGES LABEL
		});
		
		VBox doctorMessagesVBox = new VBox();
		doctorMessagesVBox.getChildren().addAll(doctorMessagesLabel, doctorMessageText, doctorMessageField, doctorSendMessageButton);
		
		
		// ================================== Doctor Button Function ================================= //
		doctorExamButton.setOnAction(e -> {
			doctorBorder.setCenter(doctorExamGrid);
		});
		doctorHistoryButton.setOnAction(e -> {
			doctorBorder.setCenter(doctorHistoryVBox);
		});
		doctorContactInfoButton.setOnAction(e -> {
			doctorBorder.setCenter(doctorContactInfoVBox);
		});
		doctorMessagesButton.setOnAction(e -> {
			doctorBorder.setCenter(doctorMessagesVBox);
		});
		
		doctorSelectDifPatientButton.setOnAction(e -> {
			window.setScene(doctorSelectPatient);
		});
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// --------------------------------- Nurse Page ----------------------------------- //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// ------------------------------------ Main -------------------------------------- //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		window.show();
	}
	
	
	
}
